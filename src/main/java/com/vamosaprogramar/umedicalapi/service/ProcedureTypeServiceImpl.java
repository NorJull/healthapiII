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
import com.vamosaprogramar.umedicalapi.dao.ProcedureTypeDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.service.async.ProcedureTypeServiceAsync;

@Service
public class ProcedureTypeServiceImpl implements ProcedureTypeService {

	@Autowired
	private ProcedureTypeDAO procedureTypeDAO;

	@Autowired
	private ProcessDAO processDAO;

	@Autowired
	private ProcedureTypeServiceAsync procedureTypeServiceAsync;

	@Override
	public Integer uploadProcedureTypeFile(MultipartFile procedureTypeFile) {

		try {

			byte[] bytes = procedureTypeFile.getBytes();

			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + procedureTypeFile.getOriginalFilename());

			Files.write(path, bytes);

			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + procedureTypeFile.getOriginalFilename());

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
			Process process = new Process(1, GeneralConstants.SUBIDA_DE_PROCEDIMIENTOS, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows, 0, 0, null);

			Integer processId = processDAO.addProcess(process);

			procedureTypeServiceAsync.addProcedureTypes(bufferedReader, processId, totalRows);

			return processId;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<ProcedureType> getProceduresType() {
		// TODO Auto-generated method stub
		return procedureTypeDAO.getProceduresType();
	}

	@Override
	public ProcedureType getProceduresType(int id) {
		// TODO Auto-generated method stub
		return procedureTypeDAO.getProceduresType(id);
	}

	@Override
	public void updateProcedureType(ProcedureType procedureType, int id) {
		// TODO Auto-generated method stub
		procedureTypeDAO.updateProcedureType(procedureType, id);

	}

}
