package com.vamosaprogramar.umedicalapi.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;
import com.vamosaprogramar.umedicalapi.exception.SpecialityDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.UserDoesNotExist;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ApplicationUser findByUsername(String username) {

		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("from ApplicationUser where username=:userName");

			theQuery.setParameter("userName", username);

			List<ApplicationUser> users = theQuery.list();

			session.getTransaction().commit();

			if (users.isEmpty())
				return null;

			ApplicationUser user = users.get(0);

			return user;

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
	public Integer saveUser(ApplicationUser user) {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();
			
			if(user.getSpecialities()!=null) {
								
				Iterator<Especialidad> it= user.getSpecialities().iterator();
				
				List<Especialidad> aux = new ArrayList<>();
				
				while(it.hasNext()) {
				
					Especialidad s = session.get(Especialidad.class, it.next().getId());
					aux.add(s);
				}
				user.setSpecialities(aux);
				}
							

			Integer userId = (Integer) session.save(user);

			session.getTransaction().commit();

			return userId;

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
	public List<ApplicationUser> getUsers() {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("From ApplicationUser");

			List<ApplicationUser> users = theQuery.list();

			session.getTransaction().commit();

			return users;

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
	public ApplicationUser getUser(int id) {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			ApplicationUser user = session.get(ApplicationUser.class, id);

			session.getTransaction().commit();

			return user;

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
	public void addSchedule(Schedule schedule, int id) throws UserDoesNotExist, SpecialityDoesNotExist {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Especialidad speciality = session.get(Especialidad.class, schedule.getSpeciality().getId());

			ApplicationUser user = session.get(ApplicationUser.class, id);

			schedule.setSpeciality(speciality);

			schedule.setUser(user);

			session.save(schedule);

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
	public void updateSchedule(Schedule schedule) {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Schedule temporalSchedule = session.get(Schedule.class, schedule.getId());

			temporalSchedule.setWeekDay(schedule.getWeekDay());
			temporalSchedule.setStartTimeTurnOne(schedule.getStartTimeTurnOne());
			temporalSchedule.setStartTimeTurnTwo(schedule.getStartTimeTurnTwo());
			temporalSchedule.setAppointmentsTurnOne(schedule.getAppointmentsTurnOne());
			temporalSchedule.setAppointmentsTurnTwo(schedule.getAppointmentsTurnTwo());

			if (schedule.getSpeciality() != null) {

				Especialidad speciality = session.get(Especialidad.class, schedule.getSpeciality().getId());
				temporalSchedule.setSpeciality(speciality);
			}

			session.saveOrUpdate(temporalSchedule);

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
	public List<Schedule> getSchedules(int id) {
		Session session = null;

		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("From Schedule sch where sch.user.id = :userId");
			theQuery.setParameter("userId", id);

			List<Schedule> schedules = theQuery.list();

			session.getTransaction().commit();

			return schedules;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

}
