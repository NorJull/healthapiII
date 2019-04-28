package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.constraintvalidators.bv.MaxValidatorForNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.TarifaProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRateId;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class ProcedureRateDAOImpl implements ProcedureRateDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<TarifaProcedimiento> getProcedureRates() {
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From TarifaProcedimiento");
			
			List<TarifaProcedimiento> procedureRates = theQuery.list();
			
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
	public void addProcedureRate(TarifaProcedimiento tarifaProcedimiento, Session session) throws ProcedureTypeDoesNotExist, DuplicateProcedureRate {

		
		ManualTarifario rateManual = session.get(ManualTarifario.class, tarifaProcedimiento.getId().getRateManual().getId()); 

		Query tipoProcedimientoQuery  = session.createQuery("From TipoProcedimiento where cup=:cupId"); 

		tipoProcedimientoQuery.setParameter("cupId", tarifaProcedimiento.getId().getProcedureType().getCup());
	
		TipoProcedimiento tipoProcedimiento = (TipoProcedimiento) tipoProcedimientoQuery.uniqueResult();
		
		//Valida si el procedimiento existe.
		if(tipoProcedimiento == null) {
			throw new ProcedureTypeDoesNotExist(tarifaProcedimiento.getId().getProcedureType().getCup());
		}
						
		tarifaProcedimiento.getId().setProcedureType(tipoProcedimiento);
		tarifaProcedimiento.getId().setRateManual(rateManual);
		
		
		
		TarifaProcedimiento procedureRateValid = session.get(TarifaProcedimiento.class, tarifaProcedimiento.getId());
		//Valida si ya hay un registro para este manual con ese procedimiento
		if(procedureRateValid != null) {
			throw new DuplicateProcedureRate();
		}
			
		
		session.save(tarifaProcedimiento);
		

	}
	
	@Override
	public boolean procedureRateExist(int manualId,String cup, Session session) {
		
		ManualTarifario rateManual = session.get(ManualTarifario.class, manualId); 
		
		Query procedureTypeQuery  = session.createQuery("From TipoProcedimiento where cup=:cupId"); 
		procedureTypeQuery.setParameter("cupId", cup);
		TipoProcedimiento procedureType = (TipoProcedimiento) procedureTypeQuery.uniqueResult();
		
		ProcedureRateId procedureRateId = new ProcedureRateId(rateManual, procedureType);
		
		TarifaProcedimiento procedureRate = session.get(TarifaProcedimiento.class, procedureRateId);
		
		if(procedureRate == null)
			return false;
		else
			return true;
	}

	@Override
	public List<TarifaProcedimiento> getProcedureRatesByManual(int manualId) {
		Session session=null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From TarifaProcedimiento a where a.id.rateManual.id=:value");
			theQuery.setParameter("value", manualId);
			
			List<TarifaProcedimiento> tarifaProcedimientos = theQuery.list();
			
			session.getTransaction().commit();
			
			return tarifaProcedimientos;
			
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
