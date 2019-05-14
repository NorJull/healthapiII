package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.MedicamentoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
@Repository
public class MedicamentoAIEPIDAOImpl implements MedicamentoAIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearMedicamantoAIEPI(MedicamentoAIEPI medicamentoAIEPI, Integer registroAIEPIId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			RegistroAIEPI registroAIEPI = session.get(RegistroAIEPI.class, registroAIEPIId);
			medicamentoAIEPI.setRegistroAIEPI(registroAIEPI);
			
			session.save(medicamentoAIEPI);

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
