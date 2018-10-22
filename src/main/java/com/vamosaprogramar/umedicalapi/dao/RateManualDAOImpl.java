package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RateManual;

@Repository
public class RateManualDAOImpl implements RateManualDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<RateManual> getRateManuals() {
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From RateManual");
			
			List<RateManual> rateManuals = theQuery.list();
			
			session.getTransaction().commit();
			
			return rateManuals;
			
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
	public RateManual getRateManual(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RateManual rateManual = session.get(RateManual.class, id);
			
			session.getTransaction().commit();
			
			return rateManual;
			
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
	public boolean rateManualExist(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			RateManual rateManual = session.get(RateManual.class, id);
			
			session.getTransaction().commit();
			
			if(rateManual == null) {
				return false;
			}
							
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(session!=null) {
				session.close();
			}
		}
		
		
		return false;
	}

	@Override
	public Integer addRateManual(RateManual rateManual) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Integer rateManualId = (Integer) session.save(rateManual);
			
			session.getTransaction().commit();
			
			return rateManualId;
			
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
	public void deleteRateManual(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			RateManual rateManual = session.get(RateManual.class, id);
			
			session.delete(rateManual);
			
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
