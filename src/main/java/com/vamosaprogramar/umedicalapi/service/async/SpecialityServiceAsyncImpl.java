package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.SpecialityDAO;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.service.ProcessService;

@Service
public class SpecialityServiceAsyncImpl implements SpecialityServiceAsync {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired 
	private SpecialityDAO specialityDAO;
	
	@Override
	@Async
	public void addProcedureTypes(BufferedReader bufferedReader, int specialityId, int processId, int totalRows) {
		
		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 10;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			//Validar si la especialidad existe en la BD
			if(!specialityDAO.specialityExist(specialityId))
				throw new SpecialityDoesNotExist();
			
			String line = bufferedReader.readLine();

			
			while(line != null) {
				
				if (currentRow % batchSize == 0) {
					session.getTransaction().commit();

					// Actualizar proceso
					percent = ((double) currentRow / totalRows) * 100;
					processService.setPercent(processId, currentRow, percent);

					session.beginTransaction();

				}
				
				
					try {
						specialityDAO.addProcedureType(specialityId, line.trim(), session);
					} catch (ProcedureTypeDoesNotExist e) {
						log = log + "\n" + "Line " + currentRow + ">>" + line + " :" + e.getMessage();
						
					}
					
				
				currentRow++;

				line = bufferedReader.readLine();
				
			}
			
			currentRow--;

			session.getTransaction().commit();
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (SpecialityDoesNotExist e) {
			log = e.getMessage();
		}finally {

			processService.setLog(processId, log);

			percent = ((double) currentRow / totalRows) * 100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());

			if (log.equals("")) {
				processService.setStatus(processId, 'T');// T:terminado
			} else {
				processService.setStatus(processId, 'I');// I:Terminado con inconsistencias
			}

			if (session.isOpen()) {
				session.close();
			}
		}
		
		
	}

}
