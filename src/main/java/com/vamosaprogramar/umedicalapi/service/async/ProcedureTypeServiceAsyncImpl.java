package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.ProcedureTypeDAO;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureType;
import com.vamosaprogramar.umedicalapi.service.ProcessService;

@Service
public class ProcedureTypeServiceAsyncImpl implements ProcedureTypeServiceAsync {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private ProcedureTypeDAO procedureTypeDAO;
	
	@Override
	@Async
	public void addProcedureTypes(BufferedReader bufferedReader, int processId, int totalRows) {
		
		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 25;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			String line = bufferedReader.readLine();
			String[] parts;
			
			ProcedureType procedureType;
			
			while(line!=null) {
				
				if(currentRow%batchSize == 0) {
					session.getTransaction().commit();
					
					//Actualizar porcentaje de ejecución
					percent = ((double) currentRow/totalRows)*100;
					processService.setPercent(processId, currentRow, percent);
					
					session.beginTransaction();
				}
				
				parts = line.split(Pattern.quote(";"));
				
				try {
					procedureType = new ProcedureType();
					
					procedureType.setCup(parts[0]);
					procedureType.setDescription(parts[1]);
					
					procedureTypeDAO.addProcedureType(procedureType,session);
					
				}catch (DuplicateProcedureType e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+" :"+ e.getMessage();
				}
				
				currentRow++;
				line = bufferedReader.readLine();
				
			}
			
			currentRow--;
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			processService.setLog(processId, log);
			
			percent = ((double) currentRow/totalRows)*100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());
			
			if(log.equals("")) {
				processService.setStatus(processId, GeneralConstants.TERMINADO);
			}else {
				processService.setStatus(processId, GeneralConstants.TERMINADO_CON_INCONSISTENCIAS);
			}
			
			if (session.isOpen()) {
				session.close();
		}
		
		
	}

}
}