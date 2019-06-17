package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
@Repository
public class ProcedimientoOrdenadoOdontologiaDAOImpl implements ProcedimientoOrdenadoOdontologiaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void crearProcedimientoOrdenadoOdontologia(ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia, Integer registroOdontologiaId){
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			RegistroOdontologia registroOdontologia = session.get(RegistroOdontologia.class, registroOdontologiaId);
		
			procedimientoOrdenadoOdontologia.setRegistroOdontologia(registroOdontologia);
			
			session.save(procedimientoOrdenadoOdontologia);
			
			session.getTransaction().commit();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}

	}

}
