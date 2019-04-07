package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ContractHistory;

@Repository
public class ContractHistoryDAOImple implements ContractHistoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dissociatePatients(int contractId, LocalDate finishDate) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			
			Query theQuery = session.createQuery("update ContractHistory set finishDate = :finishDate where contractId = :contractId and finishDate= :finishDateNull");
			
			theQuery.setParameter("finishDate", finishDate);
			theQuery.setParameter("contractId", contractId);
			theQuery.setParameter("finishDateNull", null);
			
			theQuery.executeUpdate();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
	}

	@Override
	public void addContractHistory(ContractHistory contractHistory, Session session) {
		session.save(contractHistory);
		
	}

	@Override
	public void dissociatePatientFromContract(int patientId, LocalDate finishDate, Session session) {
					
			Query theQuery = session.createQuery("update ContractHistory set finishDate = :finishDate where patientId = :patientId and finishDate= :finishDateNull");
			
			theQuery.setParameter("finishDate", finishDate);
			theQuery.setParameter("patientId", patientId);
			theQuery.setParameter("finishDateNull", null);
			
			theQuery.executeUpdate();		
	
	}

}
