package com.vamosaprogramar.umedicalapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	
	@GetMapping()
	public List<Patient> getPatients(){
	
		return patientService.getPatients();
	}
	
	
	@PostMapping(path = "/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadPatientsFile(@RequestParam("file") MultipartFile patientFile){
		
		//contract procedures
		if(patientFile.isEmpty()) {
			
			return null;
		}
		
	    Integer processId = patientService.uploadPatientFile(patientFile);
		
		return processId;
	}

}
