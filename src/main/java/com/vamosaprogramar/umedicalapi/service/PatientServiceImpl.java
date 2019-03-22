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

import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.service.async.PatientServiceAsync;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private PatientServiceAsync patientServiceAsync;

	@Autowired
	private PatientDAO patientDAO;
	
	
	@Override
	public Integer uploadPatientFile(MultipartFile patientFile) {
		
		String uploadFolder = ".//src//main//resources//myFiles//";
		
		try {
			
			byte[] bytes = patientFile.getBytes();
			
			Path path = Paths.get(uploadFolder + patientFile.getOriginalFilename());
			
			Files.write(path,bytes);
			
			FileReader fileReader = new FileReader(uploadFolder + patientFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			bufferedReader.reset();
			
			Process process = new Process(1, "SUBIDA DE PACIENTES", 'E', LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			

			patientServiceAsync.addPatients(bufferedReader,processId, totalRows);
			
			
			return processId;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Patient> getPatients() {
		
		return patientDAO.getPatients();
	}

	@Override
	public Patient getPatientByDocumentAndDocumentType(String document, String documentType) {
		return patientDAO.getPatientByDocumentAndDocumentType(document, documentType);
	}

	@Override
	public void addParticularPatient(Patient patient) {
		patientDAO.addParticularPatient(patient);
	}

}
