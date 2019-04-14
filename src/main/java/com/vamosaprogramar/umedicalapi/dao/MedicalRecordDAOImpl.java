package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;

@Repository
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<MedicalRecord> getMedicalRecordsByPatient(int patientId) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from MedicalRecord where patientId = :patientId");
			theQuery.setParameter("patientId", patientId);
			
			List<MedicalRecord> medicalRecords = theQuery.list();
			
			return medicalRecords;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		return null;
	}

	@Override
	public void addMedicalRecord(MedicalRecord medicalRecord) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(medicalRecord);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}

	}

}
