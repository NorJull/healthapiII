package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.APPOINTMENT_STATE_SCHEDULED;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.APPOINTMENT_STATE_CANCELED;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Appointment;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;

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

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
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
		} finally {
			if (session.isOpen()) {
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

			// Fijar especialidad
			Especialidad speciality = session.get(Especialidad.class, appointment.getSpeciality().getId());

			appointment.setSpeciality(speciality);

			// Fijar paciente
			Patient patient = session.get(Patient.class, appointment.getPatient().getId());

			appointment.setPatient(patient);

			// Fijar Doctor
			ApplicationUser applicationUser = session.get(ApplicationUser.class,
					appointment.getApplicationUser().getId());

			appointment.setApplicationUser(applicationUser);

			session.save(appointment);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
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
		} finally {
			if (session.isOpen()) {
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

			Query theQuery = session.createQuery(
					"from Appointment where speciality.id =:specialityID and state=:state and date >=:startDate and date <:finishDate");

			theQuery.setParameter("specialityID", specialityId);
			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("startDate", startDate);
			theQuery.setParameter("finishDate", finishDate);

			List<Appointment> appointments = theQuery.list();

			session.getTransaction().commit();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
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

			Query theQuery = session.createQuery(
					"from Appointment where speciality.id =:specialityID and state=:state and applicationUser.id =:doctorID and date >=:startDate and date <:finishDate order by time ASC");

			theQuery.setParameter("specialityID", specialityId);
			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("doctorID", doctorId);
			theQuery.setParameter("startDate", startDate);
			theQuery.setParameter("finishDate", finishDate);

			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public List<Appointment> getRegisteredAppointmentsOfTheDay(int specialityId, int doctorId, LocalDate dayDate) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery(
					"from Appointment where speciality.id =:specialityID and applicationUser.id =:doctorID and state =:state and date =:dayDate ORDER BY time ASC");

			theQuery.setParameter("specialityID", specialityId);
			theQuery.setParameter("doctorID", doctorId);
			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("dayDate", dayDate);
			

			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public void toCancelAnAppointment(int id) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Appointment appointment = session.get(Appointment.class, id);

			appointment.setState(APPOINTMENT_STATE_CANCELED);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}

	}

	@Override
	public List<Appointment> getAppointmentByPatient(int patientId) {

		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("from Appointment where patient.id =:patientID");

			theQuery.setParameter("patientID", patientId);

			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public List<Appointment> getAppointmentByPatientByState(int patientId, String state) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("from Appointment where patient.id =:patientID and state =:state");

			theQuery.setParameter("patientID", patientId);
			theQuery.setParameter("state", state);
			
			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public List<Appointment> getRegisteredAppointmentsOfTheCurrentDayAllDoctors(LocalDate today) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("from Appointment where state =:state and date =:dayDate ORDER BY time ASC");

			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("dayDate", today);
			
			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public List<Appointment> getRegisteredAppointmentsOfTheCurrentDayPerDoctor(LocalDate today, int doctorId, int specialityId) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("from Appointment where state =:state and applicationUser.id =:doctorID and speciality.id =:specialityId and date =:dayDate ORDER BY time ASC");

			theQuery.setParameter("state", APPOINTMENT_STATE_SCHEDULED);
			theQuery.setParameter("doctorID", doctorId);
			theQuery.setParameter("specialityId", specialityId);
			theQuery.setParameter("dayDate", today);
			
			List<Appointment> appointments = theQuery.list();

			return appointments;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public void cambiarEstado(int appointmentId, String aPPOINTMENT_STATE_FINISHED) {
		Session session = null;
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Appointment appointment = session.get(Appointment.class, appointmentId);

			appointment.setState(aPPOINTMENT_STATE_FINISHED);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		
	}

	
}
