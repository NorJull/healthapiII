package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;

@Repository
public class ManualTarifarioDAOImpl implements ManualTarifarioDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ManualTarifario> obtenerManualesTarifarios() {

		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("From ManualTarifario");

			List<ManualTarifario> manualesTarifarios = theQuery.list();

			session.getTransaction().commit();

			return manualesTarifarios;

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
	public ManualTarifario obtenerManualTarifario(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			ManualTarifario manualTarifario = session.get(ManualTarifario.class, id);

			session.getTransaction().commit();

			return manualTarifario;

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
	public boolean exiteManualTarifario(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			ManualTarifario manualTarifario = session.get(ManualTarifario.class, id);

			session.getTransaction().commit();

			if (manualTarifario == null) {
				return false;
			}

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}

		return false;
	}

	@Override
	public Integer crearManualTarifario(ManualTarifario rateManual) {
		Session session = null;

		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			Integer manualTarifarioId = (Integer) session.save(rateManual);

			session.getTransaction().commit();

			return manualTarifarioId;

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
	public void eliminarManualTarifario(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			ManualTarifario manualTarifario = session.get(ManualTarifario.class, id);

			session.delete(manualTarifario);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
