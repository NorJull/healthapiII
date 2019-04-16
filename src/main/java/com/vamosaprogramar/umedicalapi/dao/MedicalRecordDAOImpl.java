package com.vamosaprogramar.umedicalapi.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.MedicalRecord;
import com.vamosaprogramar.umedicalapi.entity.result.MedicalRecordResult;

@Repository
public class MedicalRecordDAOImpl implements MedicalRecordDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<MedicalRecordResult> getMedicalRecordsByPatient(int patientId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery(
					"select mr.id as id, mr.patientId as patientId, mr.date as date, mr.time as time, mr.particular as particular, mr.consultationReason as consultationReason from MedicalRecord mr where mr.patientId = :patientId");
			theQuery.setParameter("patientId", patientId);

			theQuery.setResultTransformer(Transformers.aliasToBean(MedicalRecordResult.class));

			List<MedicalRecordResult> medicalRecordResults = theQuery.list();

			return medicalRecordResults;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
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
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@Override
	public MedicalRecord getMedicalRecord(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			MedicalRecord medicalRecord = (MedicalRecord) session.get(MedicalRecord.class, id);

			return medicalRecord;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return null;
	}

}
