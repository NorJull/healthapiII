package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RemisionOdontologia;
@Repository
public class RemsionOdontologiaDAOImpl implements RemisionOdontologiaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearRemisionOdontologia(RemisionOdontologia remisionOdontologia, Integer registroOdontologiaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			RegistroOdontologia registroOdontologia = session.get(RegistroOdontologia.class, registroOdontologiaId);
			remisionOdontologia.setRegistroOdontologia(registroOdontologia);
			
			session.save(remisionOdontologia);
			
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
