package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vamosaprogramar.umedicalapi.entity.Appointment;

public class AppointmentDAOImpl implements AppointmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Appointment> getAppointments() {
		
		
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from Appointment");
			
			List<Appointment> appointments = theQuery.list();
			
			session.getTransaction().commit();
			
			return appointments;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
			
		}
		
		
		return null;
	}

	@Override
	public Appointment getAppointment(int id) {
		
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Appointment appointment = session.get(Appointment.class, id);
			
			session.getTransaction().commit();
			
			return appointment;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
			
		}
		
		return null;
	}

	@Override
	public void addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub

	}

}
