package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.EspecialidadDAO;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.service.ProcessService;

@Service
public class ServicioEspecialidadAsyncImpl implements ServicioEspecialidadAsync {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProcessService processService;

	@Autowired
	private EspecialidadDAO especialidadDAO;

	@Override
	@Async
	public void asociarTiposProcedimientos(BufferedReader bufferedReader, int especialidadId, int procesoId,
			int totalRows) {

		String log = "";
		Session session = null;
		int currentRow = 1;
		double percent = 0;
		int batchSize = 10;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			// Validar si la especialidad existe en la BD
			if (!especialidadDAO.existeEspecialidad(especialidadId))
				throw new SpecialityDoesNotExist();

			String line = bufferedReader.readLine();

			while (line != null) {

				if (currentRow % batchSize == 0) {
					session.getTransaction().commit();

					// Actualizar proceso
					percent = ((double) currentRow / totalRows) * 100;
					processService.setPercent(procesoId, currentRow, percent);

					session.beginTransaction();

				}

				try {
					especialidadDAO.asociarTipoProcedimento(especialidadId, line.trim(), session);
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
		} catch (SpecialityDoesNotExist e) {
			log = e.getMessage();
		} finally {

			processService.setLog(procesoId, log);

			percent = ((double) currentRow / totalRows) * 100;
			processService.setPercent(procesoId, currentRow, percent);

			processService.setFinishDate(procesoId, LocalDateTime.now());

			if (log.equals("")) {
				processService.setStatus(procesoId, GeneralConstants.TERMINADO);
			} else {
				processService.setStatus(procesoId, GeneralConstants.TERMINADO_CON_INCONSISTENCIAS);
			}

			if (session.isOpen()) {
				session.close();
			}
		}

	}

}
