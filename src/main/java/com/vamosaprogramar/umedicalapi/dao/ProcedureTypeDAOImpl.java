package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureType;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class ProcedureTypeDAOImpl implements ProcedureTypeDAO {
	
	@Autowired
	private	SessionFactory sessionFactory;
	
	@Override
	public void addProcedureType(ProcedureType procedureType) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(procedureType);
			
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
	public List<ProcedureType> getProceduresType() {
		Session session = null;
		
		try {
		
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from ProcedureType");
			
			List<ProcedureType> proceduresType = theQuery.list();
						
			session.getTransaction().commit();
			
			return proceduresType;
			 
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
	public ProcedureType getProceduresType(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			ProcedureType procedureType = session.get(ProcedureType.class, id);
			session.getTransaction().commit();
			
			return procedureType;
			
			
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
	public void updateProcedureType(ProcedureType procedureType, int id) {
		Session session =  null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			procedureType.setId(id);
			
			session.update(procedureType);
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		
	}

	@Override
	public void addProcedureType(ProcedureType procedureType, Session session) throws DuplicateProcedureType {
		
		Query procedureTypeQuery  = session.createQuery("From ProcedureType where cup=:cupId"); 

		procedureTypeQuery.setParameter("cupId", procedureType.getCup());
	
		ProcedureType procedureTypeExist = (ProcedureType) procedureTypeQuery.uniqueResult();
		
		//Valida si el procedimiento existe.
		if(procedureTypeExist != null) {
			throw new DuplicateProcedureType();
		}
		
		
		session.save(procedureType);
	}

}
