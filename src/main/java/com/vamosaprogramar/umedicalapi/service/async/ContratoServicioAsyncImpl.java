package com.vamosaprogramar.umedicalapi.service.async;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.COLOMBIA_TIME_ZONE_ID;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.ContratoDAO;
import com.vamosaprogramar.umedicalapi.dao.ContractHistoryDAO;
import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.entity.ContractHistory;
import com.vamosaprogramar.umedicalapi.exception.ContractDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.IncompleteRow;
import com.vamosaprogramar.umedicalapi.exception.PatientDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;
import com.vamosaprogramar.umedicalapi.service.ProcessService;

@Service
public class ContratoServicioAsyncImpl implements ServicioContratoAsync {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ContratoDAO contratoDAO;

	@Autowired
	private ContractHistoryDAO contractHistoryDAO;

	@Autowired
	private PatientDAO patientDAO;

	@Autowired
	private ProcessService processService;

	@Override
	@Async
	public void asociarTiposProcedimientos(BufferedReader bufferedReader, int contratoId, int processId, int totalRows) {

		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 10;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			// Validar si el contrato existe en la Base de Datos
			if (!contratoDAO.existeContrato(contratoId)) {
				throw new ContractDoesNotExist();
			}
			
			//Desasociar todos los TipoProcedimiento del contrato
			contratoDAO.desasociarTiposProcedimientos(contratoId);


			String line = bufferedReader.readLine();

			while (line != null) {

				if (currentRow % batchSize == 0) {
					session.getTransaction().commit();

					// Actualizar proceso
					percent = ((double) currentRow / totalRows) * 100;
					processService.setPercent(processId, currentRow, percent);

					session.beginTransaction();

				}

				try {

					contratoDAO.asociarTipoProcedimiento(contratoId, line, session);

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
		} catch (ContractDoesNotExist e) {
			log = e.getMessage();
		} finally {

			processService.setLog(processId, log);

			percent = ((double) currentRow / totalRows) * 100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());

			if (log.equals("")) {
				processService.setStatus(processId, GeneralConstants.TERMINADO);
			} else {
				processService.setStatus(processId, GeneralConstants.TERMINADO_CON_INCONSISTENCIAS); 
			}

			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	@Async
	public void addPatients(BufferedReader bufferedReader, int contractId, Integer processId, int totalRows) {
		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 10;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			// Validar si el contrato existe en la Base de Datos
			if (!contratoDAO.existeContrato(contractId)) {
				throw new ContractDoesNotExist();
			}

			// Desasociar a todos los pacientes del contrato
			ZonedDateTime todayWithZone = ZonedDateTime.now(ZoneId.of(COLOMBIA_TIME_ZONE_ID));
			LocalDate today = todayWithZone.toLocalDate();

			contractHistoryDAO.dissociatePatients(contractId, today);
			patientDAO.dissociatePatientsFromContract(contractId);

			String line = bufferedReader.readLine();
			String[] parts;
			String document;
			String documentType;

			while (line != null) {

				if (currentRow % batchSize == 0) {
					session.getTransaction().commit();

					// Actualizar proceso
					percent = ((double) currentRow / totalRows) * 100;
					processService.setPercent(processId, currentRow, percent);

					session.beginTransaction();

				}

				parts = line.split(Pattern.quote(";"));

				try {
					// Validación 1: Registro incompleto
					if (parts.length != 2) {
						throw new IncompleteRow();
					}
					document = parts[0];
					documentType = parts[1];
					
					int patientId = contratoDAO.addPatient(contractId, document.trim(), documentType.trim(), session);
					contractHistoryDAO.dissociatePatientFromContract(patientId, today, session);
					ContractHistory contractHistory = new ContractHistory(contractId, patientId, today, null);
					contractHistoryDAO.addContractHistory(contractHistory, session);

				} catch (IncompleteRow e) {
					log = log + "\n" + "Line " + currentRow + ">>... :" + e.getMessage();

				} catch (PatientDoesNotExist e) {
					log = log + "\n" + "Line " + currentRow + ">>" + line + " :" + e.getMessage();
				}

				currentRow++;

				line = bufferedReader.readLine();

			}
			currentRow--;

			session.getTransaction().commit();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ContractDoesNotExist e) {
			log = e.getMessage();
		} finally {

			processService.setLog(processId, log);

			percent = ((double) currentRow / totalRows) * 100;
			processService.setPercent(processId, currentRow, percent);

			processService.setFinishDate(processId, LocalDateTime.now());

			if (log.equals("")) {
				processService.setStatus(processId, GeneralConstants.TERMINADO);
			} else {
				processService.setStatus(processId, GeneralConstants.TERMINADO_CON_INCONSISTENCIAS);
			}

			if (session.isOpen()) {
				session.close();
			}
		}

	}

}
