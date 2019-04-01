package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.Patient;

public interface PatientDAO {

	public Patient getPatientByDocumentAndDocumentType(String document,String documentType,Session session);

	public Patient getPatientByDocumentAndDocumentType(String document,String documentType);
	
	public void addPatient(Patient patient, Session session);
	
	public void updatePatient(Patient patient, Session session);

	public List<Patient> getPatients();

	public void addParticularPatient(Patient patient);
	
	public void dissociatePatientsFromContract(int contractId);
	
	
}
