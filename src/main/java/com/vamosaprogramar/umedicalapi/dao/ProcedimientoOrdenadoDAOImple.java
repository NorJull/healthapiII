package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
@Repository
public class ProcedimientoOrdenadoDAOImple implements ProcedimientoOrdenadoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void crearProcedimientoOrdenado(ProcedimientoOrdenado procedimientosOrdenado,
			Integer registroHistoriaClinicaId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RegistroHistoriaClinica registroHistoriaClinica = session.get(RegistroHistoriaClinica.class,registroHistoriaClinicaId);

			procedimientosOrdenado.setRegistroHistoriaClinica(registroHistoriaClinica);
			
			session.save(procedimientosOrdenado);
			
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
