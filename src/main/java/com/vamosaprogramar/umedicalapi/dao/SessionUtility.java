package com.vamosaprogramar.umedicalapi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionUtility {

	@Autowired
	private static SessionFactory sessionFactory;

	private static Session session;

	public static Session startTransaction() {

		openSession();

		session.beginTransaction();

		return session;

	}

	public static Session getSession() {
		if (session.isOpen()) {
			return session;
		}
		return null;
	}

	public static void commit() {

		session.getTransaction().commit();
	}

	public static void rollback() {
		session.getTransaction().rollback();

	}

	private static void openSession() {
		if (session == null) {
			session = sessionFactory.openSession();
		} else {
			if (!session.isOpen()) {
				session = sessionFactory.openSession();
			}
		}

	}

	public static void closeSession() {
		if (session.isOpen()) {
			session.close();
		}
	}
}
