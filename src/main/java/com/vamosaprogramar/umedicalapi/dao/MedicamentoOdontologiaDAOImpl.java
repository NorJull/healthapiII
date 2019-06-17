package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.MedicamentoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;

@Repository
public class MedicamentoOdontologiaDAOImpl implements MedicamentoOdontologiaDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void crearMedicamentoOdontologia(MedicamentoOdontologia medicamentoOdontologia, Integer registroOdontologiaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RegistroOdontologia registroOdontologia = session.get(RegistroOdontologia.class, registroOdontologiaId);
			medicamentoOdontologia.setRegistroOdontologia(registroOdontologia);
		
			session.save(medicamentoOdontologia);
			
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
