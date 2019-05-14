package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
@Repository
public class ProcedimientoOrdenadoAIEPIDAOImpl implements ProcedimientoOrdenadoAIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearProcedimientoOrdenadoAIEPI(ProcedimientoOrdenadoAIEPI procedimientoOrdenadoAIEPI,
			Integer registroAIEPIId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			RegistroAIEPI registroAIEPI = session.get(RegistroAIEPI.class, registroAIEPIId);
			procedimientoOrdenadoAIEPI.setRegistroAIEPI(registroAIEPI);

			session.save(procedimientoOrdenadoAIEPI);

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
