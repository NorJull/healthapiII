package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Town;

@Repository
public class TownDAOImpl implements TownDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Town> getTowns() {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query theQuery = session.createQuery("from Town");

			List<Town> towns = theQuery.list();

			session.getTransaction().commit();

			return towns;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public Town getTown(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Town town = session.get(Town.class, id);
			session.getTransaction().commit();

			return town;

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return null;
	}

	@Override
	public List<Town> getTownsPerDepartament(int departamentId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query theQuery = session.createQuery("from Town where departament=:departament");

			theQuery.setParameter("departament", departamentId);

			List<Town> towns = theQuery.list();

			session.getTransaction().commit();

			return towns;
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
		return null;
	}

}
