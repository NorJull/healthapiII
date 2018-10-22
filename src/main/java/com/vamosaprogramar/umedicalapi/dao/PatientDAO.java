package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.Patient;

public interface PatientDAO {

	public Patient getPatientByDocument(String document,Session session);

	public void addPatient(Patient patient, Session session);
	
	public void updatePatient(Patient patient, Session session);

	public List<Patient> getPatients();
}
