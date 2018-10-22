package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Schedule getScheduleByUserIdAndWeekDay(int userId, int weekDay) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theScheduleQuery = session.createQuery("From Schedule sch where sch.user.id = :userId and sch.weekDay = :weekDay"); 
            
			theScheduleQuery.setParameter("userId", userId);
			theScheduleQuery.setParameter("weekDay", weekDay);
			
			
			Schedule schedule = (Schedule) theScheduleQuery.uniqueResult();
		
						
			session.getTransaction().commit();
			
			
			return schedule;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
		}
		
		return null;
	}

}
