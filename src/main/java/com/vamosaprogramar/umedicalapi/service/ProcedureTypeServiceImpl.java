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
	public Integer uploadProcedureTypeFile(MultipartFile procedureTypeFile){

		
		
		 
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>"+1);
			String uploadFolder = ".//src//main//resources//myFiles//";
			
			byte[] bytes = procedureTypeFile.getBytes();
			System.out.println(">>>>>>>>>>>>>>>>>>"+2);
			Path path = Paths.get(uploadFolder + procedureTypeFile.getOriginalFilename());
			System.out.println(">>>>>>>>>>>>>>>>>>"+3);
			Files.write(path, bytes);
			System.out.println(">>>>>>>>>>>>>>>>>>"+4);
			FileReader fileReader = new FileReader(uploadFolder + procedureTypeFile.getOriginalFilename());

			BufferedReader bufferedReader = new BufferedReader(fileReader);
			System.out.println(">>>>>>>>>>>>>>>>>>"+5);
			//Contar las lineas a procesar
			bufferedReader.mark(100000);
			System.out.println(">>>>>>>>>>>>>>>>>>"+6);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			System.out.println(">>>>>>>>>>>>>>>>>>"+7);
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			System.out.println(">>>>>>>>>>>>>>>>>>"+8);
			//Crear el proceso
			Process process = new Process(1, "PROCEDIMIENTOS", 'E', LocalDateTime.now(), null, totalRows, 0, 0, null);
			System.out.println(">>>>>>>>>>>>>>>>>>"+9);
		
			Integer processId = processDAO.addProcess(process);
			System.out.println(">>>>>>>>>>>>>>>>>>"+10);
			procedureTypeServiceAsync.addProcedureTypes(bufferedReader, processId, totalRows);
			System.out.println(">>>>>>>>>>>>>>>>>>"+11);
			return processId;
			
		}catch (Exception e) {
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
