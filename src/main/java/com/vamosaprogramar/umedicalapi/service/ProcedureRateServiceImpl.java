package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.dao.ProcedureRateDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.dao.RateManualDAO;
import com.vamosaprogramar.umedicalapi.dao.SessionUtility;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRate;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRateId;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.entity.RateManual;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.RateManualDoesNotExist;

@Service
public class ProcedureRateServiceImpl implements ProcedureRateService {

	@Autowired
	private ProcedureRateDAO procedureRateDAO;

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProcessDAO processDAO;

	@Autowired
	private RateManualDAO rateManualDAO;

	@Autowired
	private ProcessService processService;

	@Override
	public void addProcedureRate(ProcedureRate procedureRate) {
		// procedureRateDAO.addProcedureRate(procedureRate);

	}

	@Override
	public List<ProcedureRate> getProcedureRates() {

		return procedureRateDAO.getProcedureRates();
	}

	@Override
	@Async
	public void addProdedureRates(BufferedReader bufferedReader, int manualId, int processId, int totalRows) {

		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 25;
	
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			// Validar si el manualId no existe en Base de Datos.
			if (!rateManualDAO.rateManualExist(manualId)) {
				throw new RateManualDoesNotExist();
			}

			
			String line = bufferedReader.readLine();
			String[] parts;

			ProcedureRate procedureRate;
			RateManual rateManual;
			ProcedureType procedureType;
		
			while (line != null) {
				
				if (currentRow % batchSize == 0) {

					session.getTransaction().commit();
										
					//Actualizar porcentaje de ejecución del proceso
					percent = ((double) currentRow/totalRows)*100;
					processService.setPercent(processId, currentRow, percent);
		
					session.beginTransaction();

				}
				
				parts = line.split(Pattern.quote(";"));
				
				
				try {
					
					procedureRate = new ProcedureRate();
					rateManual = new RateManual();
					procedureType = new ProcedureType();
					
					rateManual.setId(manualId);
					procedureType.setCup(parts[0]);
					procedureRate.setValue(Integer.parseInt(parts[1]));
					
					procedureRate.setId(new ProcedureRateId(rateManual, procedureType));
					
					procedureRateDAO.addProcedureRate(procedureRate, session);
				
					
				} catch (NumberFormatException e) {
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+" :"+ "Invalid code or number format";
				} catch (ProcedureTypeDoesNotExist e) {
					
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+" :"+ e.getMessage();
				} catch (DuplicateProcedureRate e) {
					
					log = log +"\n"+"Line "+currentRow+">>"+parts[0]+";"+parts[1]+" :"+ e.getMessage();
				}
				
				currentRow++;
			
				line = bufferedReader.readLine();
			}
			currentRow--;
			
			session.getTransaction().commit();

		} catch (RateManualDoesNotExist e) {
			log = e.getMessage();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		
		
			processService.setLog(processId, log);
	
			percent = ((double) currentRow/totalRows)*100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());
	
			if(log.equals("")) {
				processService.setStatus(processId, 'T');//T:terminado
			}else {
				processService.setStatus(processId, 'I');//I:Terminado con inconsistencias
			}
			
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<ProcedureRate> getProcedureRatesByManual(int manualId) {
		
		return procedureRateDAO.getProcedureRatesByManual(manualId);
	}

}
