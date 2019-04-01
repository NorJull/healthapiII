package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vamosaprogramar.umedicalapi.entity.ContractHistory;

public class ContractHistoryDAOImple implements ContractHistoryDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dissociatePatients(int contractId, LocalDate finishDate) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			
			Query theQuery = session.createQuery("update ContractHistory set finishDate = :finishDate where contractId = :contractId");
			
			theQuery.setParameter("finishDate", finishDate);
			theQuery.setParameter("contractId", contractId);
			
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

}
