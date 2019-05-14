package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
@Repository
public class ProcedimentoAIEPIDAOImple implements ProcedimentoAIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearProcedimientoAIEPI(ProcedimientoAIEPI procedimientoAIEPI, Integer registroAIEPIId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			RegistroAIEPI registroAIEPI = session.get(RegistroAIEPI.class, registroAIEPIId);
			procedimientoAIEPI.setRegistroAIEPI(registroAIEPI);

			session.save(procedimientoAIEPI);

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
