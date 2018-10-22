package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.constraintvalidators.bv.MaxValidatorForNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedureRate;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRateId;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.RateManual;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class ProcedureRateDAOImpl implements ProcedureRateDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<ProcedureRate> getProcedureRates() {
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From ProcedureRate");
			
			List<ProcedureRate> procedureRates = theQuery.list();
			
			session.getTransaction().commit();
			
			return procedureRates;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public void addProcedureRate(ProcedureRate procedureRate, Session session) throws ProcedureTypeDoesNotExist, DuplicateProcedureRate {

		
		RateManual rateManual = session.get(RateManual.class, procedureRate.getId().getRateManual().getId()); 

		Query procedureTypeQuery  = session.createQuery("From ProcedureType where cup=:cupId"); 

		procedureTypeQuery.setParameter("cupId", procedureRate.getId().getProcedureType().getCup());
	
		ProcedureType procedureType = (ProcedureType) procedureTypeQuery.uniqueResult();
		
		//Valida si el procedimiento existe.
		if(procedureType == null) {
			throw new ProcedureTypeDoesNotExist(procedureRate.getId().getProcedureType().getCup());
		}
						
		procedureRate.getId().setProcedureType(procedureType);
		procedureRate.getId().setRateManual(rateManual);
		
		
		
		ProcedureRate procedureRateValid = session.get(ProcedureRate.class, procedureRate.getId());
		//Valida si ya hay un registro para este manual con ese procedimiento
		if(procedureRateValid != null) {
			throw new DuplicateProcedureRate();
		}
			
		
		session.save(procedureRate);
		

	}
	
	@Override
	public boolean procedureRateExist(int manualId,String cup, Session session) {
		
		RateManual rateManual = session.get(RateManual.class, manualId); 
		
		Query procedureTypeQuery  = session.createQuery("From ProcedureType where cup=:cupId"); 
		procedureTypeQuery.setParameter("cupId", cup);
		ProcedureType procedureType = (ProcedureType) procedureTypeQuery.uniqueResult();
		
		ProcedureRateId procedureRateId = new ProcedureRateId(rateManual, procedureType);
		
		ProcedureRate procedureRate = session.get(ProcedureRate.class, procedureRateId);
		
		if(procedureRate == null)
			return false;
		else
			return true;
	}

	@Override
	public List<ProcedureRate> getProcedureRatesByManual(int manualId) {
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From ProcedureRate a where a.id.rateManual.id=:value");
			theQuery.setParameter("value", manualId);
			
			List<ProcedureRate> procedureRates = theQuery.list();
			
			session.getTransaction().commit();
			
			return procedureRates;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

}
