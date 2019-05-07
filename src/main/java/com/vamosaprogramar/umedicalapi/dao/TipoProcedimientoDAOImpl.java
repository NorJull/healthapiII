package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureType;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class TipoProcedimientoDAOImpl implements TipoProcedimientoDAO {
	
	@Autowired
	private	SessionFactory sessionFactory;
	
	@Override
	public void crearTipoProcedimiento(TipoProcedimiento tipoProcedimiento) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(tipoProcedimiento);
			
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
	public List<TipoProcedimiento> getTiposProcedimientos() {
		Session session = null;
		
		try {
		
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from TipoProcedimiento");
			
			List<TipoProcedimiento> tiposProcedimientos = theQuery.list();
						
			session.getTransaction().commit();
			
			return tiposProcedimientos;
			 
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
	public TipoProcedimiento getTipoProcedimiento(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			TipoProcedimiento tipoProcedimiento = session.get(TipoProcedimiento.class, id);
			session.getTransaction().commit();
			
			return tipoProcedimiento;
			
			
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
	public void actualizarTipoProcedimiento(TipoProcedimiento tipoProcedimiento, int id) {
		Session session =  null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			tipoProcedimiento.setId(id);
			
			session.update(tipoProcedimiento);
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
	public void crearTipoProcedimiento(TipoProcedimiento tipoProcedimiento, Session session) throws DuplicateProcedureType {
		
		Query procedureTypeQuery  = session.createQuery("From TipoProcedimiento where cup=:cupId"); 

		procedureTypeQuery.setParameter("cupId", tipoProcedimiento.getCup());
	
		TipoProcedimiento procedureTypeExist = (TipoProcedimiento) procedureTypeQuery.uniqueResult();
		
		//Valida si el procedimiento existe.
		if(procedureTypeExist != null) {
			throw new DuplicateProcedureType();
		}
			
		session.save(tipoProcedimiento);
	}

	@Override
	public List<TipoProcedimiento> getTiposProcedimientos(String codigoConcepto, String genero) {
		Session session = null;
		
		try {
		
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from TipoProcedimiento where codigoConcepto=:codigoConcepto and (genero=:genero or genero=:generoU)");
			
			theQuery.setParameter("codigoConcepto", codigoConcepto);
			theQuery.setParameter("genero", genero);
			theQuery.setParameter("generoU", "U");
			
			List<TipoProcedimiento> tiposProcedimientos = theQuery.list();
						
			session.getTransaction().commit();
			
			return tiposProcedimientos;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		
		return null;
	}

	public List<TipoProcedimiento> getTiposProcedimientos(String codigoConcepto) {
		Session session = null;
		
		try {
		
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from TipoProcedimiento where codigoConcepto=:codigoConcepto");
			
			theQuery.setParameter("codigoConcepto", codigoConcepto);
			
			List<TipoProcedimiento> tiposProcedimientos = theQuery.list();
						
			session.getTransaction().commit();
			
			return tiposProcedimientos;
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		
		return null;
	}
}
