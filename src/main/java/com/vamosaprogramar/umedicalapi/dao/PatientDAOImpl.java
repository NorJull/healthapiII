package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Departament;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Town;

@Repository
public class PatientDAOImpl implements PatientDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Patient getPatientByDocumentAndDocumentType(String document, String documentType, Session session) {

		Query patientQuery = session
				.createQuery("From Patient where document=:documentNumber and documentType=:documentT");

		patientQuery.setParameter("documentNumber", document);
		patientQuery.setParameter("documentT", documentType);
		Patient patient = (Patient) patientQuery.uniqueResult();

		return patient;
	}

	@Override
	public void addPatient(Patient patient, Session session) {

		if (patient.getDepartament() != null) {

			Departament departament = session.get(Departament.class, patient.getDepartament().getId());

			patient.setDepartament(departament);
		}

		if (patient.getTown() != null) {
			Town town = session.get(Town.class, patient.getTown().getId());

			patient.setTown(town);
		}

		session.save(patient);
	} 

	@Override
	public void updatePatient(Patient patient, Session session) {
		if (patient.getDepartament() != null) {

			Departament departament = session.get(Departament.class, patient.getDepartament().getId());

			patient.setDepartament(departament);
		}

		if (patient.getTown() != null) {
			Town town = session.get(Town.class, patient.getTown().getId());

			patient.setTown(town);
		}

	}

	@Override
	public List<Patient> getPatients() {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("From Patient");

			List<Patient> patients = theQuery.list();

			session.getTransaction().commit();

			return patients;

		} catch (Exception e) {
			if (session.isOpen()) {
				session.close();
			}
		}

		return null;
	}

	@Override
	public Patient getPatientByDocumentAndDocumentType(String document, String documentType) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Query patientQuery = session
					.createQuery("From Patient where document=:documentNumber and documentType=:documentT");

			patientQuery.setParameter("documentNumber", document);
			patientQuery.setParameter("documentT", documentType);
			Patient patient = (Patient) patientQuery.uniqueResult();

			session.getTransaction().commit();

			return patient;

		} catch (Exception e) {
			if (session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void addParticularPatient(Patient patient) {
		Session session = null;
		try {
			session = sessionFactory.openSession();

			session.beginTransaction();
			
			if (patient.getDepartament() != null) {

				Departament departament = session.get(Departament.class, patient.getDepartament().getId());

				patient.setDepartament(departament);
			}

			if (patient.getTown() != null) {
				Town town = session.get(Town.class, patient.getTown().getId());

				patient.setTown(town);
			}

			session.save(patient);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		
	}

}
