package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;

@Repository
public class AIEPIDAOImpl implements AIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<AIEPI> getAIEPIsByPatient(int patientId) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();

			session.beginTransaction();
			
			Query theQuery = session.createQuery("from AIEPI where patientId = :patientId");
			
			theQuery.setParameter("patientId", patientId);
			
			List<AIEPI> aiepis = theQuery.list();			
			
			return aiepis;
			
		}catch (Exception e) {
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
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		
	}

}
