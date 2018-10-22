package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.HealthEntity;

@Repository
public class HealthEntityDAOImple implements HealthEntityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<HealthEntity> getHealthEntities() {
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from HealthEntity");
			
			List<HealthEntity> healthEntities = theQuery.list();
			
			session.getTransaction().commit();
			
			return healthEntities; 
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
			
		}
		
		return null;
	}

	@Override
	public HealthEntity getHealthEntity(int id) {
		
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			HealthEntity healthEntity =  session.get(HealthEntity.class, id);
						
			session.getTransaction().commit();
			
			return healthEntity;
	
			
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
	public HealthEntity getHealthEntity(String reps) {
		
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from HealthEntity where reps=:REPS");
			
			theQuery.setParameter("REPS", reps);
			
			HealthEntity healthEntity =  (HealthEntity) theQuery.uniqueResult();
			
			session.getTransaction().commit();
			
			return healthEntity;
	
			
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
	public void addHealthEntity(HealthEntity healthEntity) {
		
		Session session = null;
		
		try {
		
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			session.save(healthEntity);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

	}

	@Override
	public void updateHealthEntity(HealthEntity healthEntity, int id) {
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			healthEntity.setId(id);
			
			
			session.update(healthEntity);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		

	}

	@Override
	public void deleteHealthEnity(int id) {
		
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("delete from HealthEntity where id=:ID"); 
			
			theQuery.setParameter("ID", id);
			
			theQuery.executeUpdate();
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}

	}

}
