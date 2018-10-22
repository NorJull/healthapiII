package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Departament;

@Repository
public class DepartamentDAOImpl implements DepartamentDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Departament> getDepartaments() {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from Departament");
			
			List<Departament> departaments = theQuery.list();
			
			session.getTransaction().commit();
			
			return departaments;
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}

	@Override
	public Departament getDepartament(int id) {
	
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Departament departament = session.get(Departament.class, id);
			
			session.getTransaction().commit();
			
			return departament;
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
