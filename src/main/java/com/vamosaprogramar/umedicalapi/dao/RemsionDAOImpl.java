package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.Remision;
@Repository
public class RemsionDAOImpl implements RemisionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearRemision(Remision remision, Integer registroHistoriaClinicaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RegistroHistoriaClinica registroHistoriaClinica = session.get(RegistroHistoriaClinica.class,registroHistoriaClinicaId);

			remision.setRegistroHistoriaClinica(registroHistoriaClinica);
			
			session.save(remision);
			
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
