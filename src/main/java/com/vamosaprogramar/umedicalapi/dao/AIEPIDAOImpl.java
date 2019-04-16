package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.AIEPIResult;

@Repository
public class AIEPIDAOImpl implements AIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AIEPIResult> getAIEPIsByPatient(int patientId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery(
					"select mr.id as id, mr.patientId as patientId, mr.date as date, mr.time as time, mr.particular as particular, mr.consultationReason as consultationReason from AIEPI mr where mr.patientId = :patientId");

			theQuery.setParameter("patientId", patientId);

			theQuery.setResultTransformer(Transformers.aliasToBean(AIEPIResult.class));

			List<AIEPIResult> aiepiResults = theQuery.list();

			return aiepiResults;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public void addAIEPI(AIEPI aiepi) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			session.save(aiepi);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}

	}

	@Override
	public AIEPI getAIEPI(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			AIEPI aiepi = session.get(AIEPI.class, id);

			return aiepi;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

}
