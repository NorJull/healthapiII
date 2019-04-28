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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.TipoProcedimientoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.service.async.ServicioTipoProcedimientoAsync;

@Service
public class ServicioTipoProcedimientoImpl implements ServicioTipoProcedimiento {

	@Autowired
	private TipoProcedimientoDAO procedureTypeDAO;

	@Autowired
	private ProcessDAO processDAO;

	@Autowired
	private ServicioTipoProcedimientoAsync procedureTypeServiceAsync;

	@Override
	public Integer subirArchivoTiposProcedimientos(MultipartFile archivoTiposProcedimientos) {

		try {

			byte[] bytes = archivoTiposProcedimientos.getBytes();

			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + archivoTiposProcedimientos.getOriginalFilename());

			Files.write(path, bytes);

			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + archivoTiposProcedimientos.getOriginalFilename());

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Contar las lineas a procesar
			bufferedReader.mark(100000);

			String line = bufferedReader.readLine();
			int totalRows = 0;

			while (line != null) {
				totalRows++;
				line = bufferedReader.readLine();
			}

			bufferedReader.reset();

			// Crear el proceso
			Process proceso = new Process(1, GeneralConstants.SUBIDA_DE_PROCEDIMIENTOS, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows, 0, 0, null);

			Integer procesoId = processDAO.addProcess(proceso);

			procedureTypeServiceAsync.agregarTiposProcedimientos(bufferedReader, procesoId, totalRows);

			return procesoId;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<TipoProcedimiento> getProceduresType() {
		return procedureTypeDAO.getTiposProcedimientos();
	}

	@Override
	public TipoProcedimiento getProceduresType(int id) {
		return procedureTypeDAO.getTipoProcedimiento(id);
	}

	@Override
	public void updateProcedureType(TipoProcedimiento procedureType, int id) {
		procedureTypeDAO.actualizarTipoProcedimiento(procedureType, id);

	}

}
