package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Patient;

public interface PatientService {



	public Integer uploadPatientFile(MultipartFile patientFile);

	public List<Patient> getPatients();

	public Patient getPatientByDocumentAndDocumentType(String document, String documentType);
}
