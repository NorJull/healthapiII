package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.APPOINTMENT_STATE_SCHEDULED;
import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Appointment;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Speciality;

@Repository
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
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			//Fijar especialidad
			Speciality speciality = session.get(Speciality.class, appointment.getSpeciality().getId());
			
			appointment.setSpeciality(speciality);
			
			
			//Fijar paciente
			Patient patient = session.get(Patient.class, appointment.getPatient().getId());
			
			appointment.setPatient(patient);
			
			//Fijar Doctor
			ApplicationUser applicationUser = session.get(ApplicationUser.class, appointment.getApplicationUser().getId());		
					
			appointment.setApplicationUser(applicationUser);
			
			session.save(appointment);
			
			session.getTransaction().commit();
							
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
			
		}

	}
	
	public void miMetodo() {
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theQuery = session.createQuery("Select count(*) as contador, date  from Appointment where "
					+ "Appointment.speciality.id=:specialityID and Appointment.state = A"
					+ " group by Appointment.date ");
			
			List<Appointment> appointments = theQuery.list();
			
			session.getTransaction().commit();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session.isOpen()) {
				session.close();
			}
			
		}
		
		
	}

	@Override
	public List<Appointment> getRegisteredAppointmentsOfAllDoctors(int specialityId, LocalDate startDate,
			LocalDate finishDate) {
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from Appointment where speciality.id =:specialityID and state=:state and date >=:startDate and date <:finishDate");
			
			theQuery.setParameter("specialityID", specialityId);
			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("startDate", startDate);
			theQuery.setParameter("finishDate", finishDate);
			
	
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
	public List<Appointment> getRegisteredAppointmentsOfOneDoctor(int specialityId, int doctorId, LocalDate startDate,
			LocalDate finishDate) {
		Session session = null;
		try {
			
			session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			Query theQuery = session.createQuery("from Appointment where speciality.id =:specialityID and status=:status and applicationUser.id =:doctorID and date >=:startDate and date <:finishDate");
			
			theQuery.setParameter("specialityID", specialityId);
			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("doctorID", doctorId);
			theQuery.setParameter("startDate", startDate);
			theQuery.setParameter("finishDate", finishDate);
			
			
			List<Appointment> appointments = theQuery.list();
			
			
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



}
