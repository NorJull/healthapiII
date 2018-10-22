package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.dao.SpecialityDAO;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.service.async.SpecialityServiceAsync;
import com.vamosaprogramar.umedicalapi.service.async.SpecialityServiceAsyncImpl;

@Service
public class SpecialityServiceImpl implements SpecialityService {

	@Autowired 
	private SpecialityDAO specialityDAO;
	
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private SpecialityServiceAsync specialityServiceAsync;
	
	@Override
	public List<Speciality> getSpecialities() {
		// TODO Auto-generated method stub
		return specialityDAO.getSpecialities();
	}
	
	@Override
	public Speciality getSpeciality(int id) {
		// TODO Auto-generated method stub
		return specialityDAO.getSpeciality(id);
	}


	@Override
	public Integer addSpeciality(Speciality speciality) {
		// TODO Auto-generated method stub
		return specialityDAO.addSpeciality(speciality);
	}

	@Override
	public List<ProcedureType> getProcedureTypes(int specialityId) {
		// TODO Auto-generated method stub
		return specialityDAO.getProcedureTypes(specialityId);
	}

	@Override
	public Integer uploadProcedureTypesFile(MultipartFile procedureTypesFile, int specialityId) {
		String uploadFolder = ".//src//main//resources//myFiles//";
		try {
			byte[] bytes = procedureTypesFile.getBytes();	
			
			Path path = Paths.get(uploadFolder + procedureTypesFile.getOriginalFilename() );
			
			Files.write(path, bytes);
			
			FileReader fileReader = new FileReader(uploadFolder + procedureTypesFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			
			Process process = new  Process(1, "PROCEDIMIENTOS DE UNA ESPECIALIDAD", 'E', LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			specialityServiceAsync.addProcedureTypes(bufferedReader, specialityId, processId, totalRows);
			
			return processId;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	



	

}
