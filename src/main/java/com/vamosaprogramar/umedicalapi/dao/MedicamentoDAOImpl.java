package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Medicamento;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;

@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearMedicamento(Medicamento medicamento, Integer registroHistoriaClinicaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RegistroHistoriaClinica registroHistoriaClinica = session.get(RegistroHistoriaClinica.class,registroHistoriaClinicaId);

			medicamento.setRegistroHistoriaClinica(registroHistoriaClinica);
			
			session.save(medicamento);
			
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
