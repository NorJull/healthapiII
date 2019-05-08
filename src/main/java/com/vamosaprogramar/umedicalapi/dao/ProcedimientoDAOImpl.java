package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Procedimiento;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;

@Repository
public class ProcedimientoDAOImpl implements ProcedimientoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearProcedimiento(Procedimiento procedimiento, Integer registroHistoriaClinicaId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			RegistroHistoriaClinica registroHistoriaClinica = session.get(RegistroHistoriaClinica.class,registroHistoriaClinicaId);

			procedimiento.setRegistroHistoriaClinica(registroHistoriaClinica);
			
			session.save(procedimiento);
			
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
