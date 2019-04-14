package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;
import com.vamosaprogramar.umedicalapi.service.MedicalRecordService;

@RestController
@RequestMapping("medicalRecords")
public class MedicalRecordController {

	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@GetMapping("patient/{patientId}")
	public List<MedicalRecord> getMedicalRecordsByPatient(@PathVariable int patientId){
		return medicalRecordService.getMedicalRecordsByPatient(patientId);
	}
	
	@PostMapping()
	public void addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordService.addMedicalRecord(medicalRecord);
	}
}
