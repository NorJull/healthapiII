package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Procedimiento;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;

@Repository
public class ProcedimientoOdontologiaDAOImpl implements ProcedimientoOdontologiaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void crearProcedimientoOdontologia(ProcedimientoOdontologia procedimientoOdontologia, Integer registroOdontologiaId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			RegistroOdontologia registroOdontologia = session.get(RegistroOdontologia.class, registroOdontologiaId);
			
			procedimientoOdontologia.setRegistroOdontologia(registroOdontologia);
		
			session.save(procedimientoOdontologia);
			
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
