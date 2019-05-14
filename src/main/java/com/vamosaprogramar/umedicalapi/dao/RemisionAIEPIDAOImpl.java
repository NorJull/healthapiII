package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RemisionAIEPI;
@Repository
public class RemisionAIEPIDAOImpl implements RemisionAIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearRemisionAIEPI(RemisionAIEPI remisionAIEPI, Integer registroAIEPIId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			RegistroAIEPI registroAIEPI = session.get(RegistroAIEPI.class, registroAIEPIId);
			remisionAIEPI.setRegistroAIEPI(registroAIEPI);

			session.save(remisionAIEPI);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

}
