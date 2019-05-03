package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Diagnostico;

@Repository
public class DiagnosticoDAOImpl implements DiagnosticoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Diagnostico obtenerDiagnosticoPorCodigo(String codigo) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from Diagnostico where codigo =:codigo");
			
			theQuery.setParameter("codigo", codigo);
			
			Diagnostico diagnostico = (Diagnostico) theQuery.uniqueResult();
			
			return diagnostico;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}
}
