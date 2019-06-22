package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;

@Repository
public class RegistroAIEPIDAOImpl implements RegistroAIEPIDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RegistroAIEPIResult> obtenerResgitrosAIEPIsPorPaciente(int pacienteId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery(
					"select mr.id as id, mr.pacienteId as pacienteId, mr.fechaEntrada as fecha, mr.horaEntrada as hora, mr.motivoConsulta as motivoConsulta from RegistroAIEPI mr where mr.pacienteId = :pacienteId");

			theQuery.setParameter("pacienteId", pacienteId);

			theQuery.setResultTransformer(Transformers.aliasToBean(RegistroAIEPIResult.class));

			List<RegistroAIEPIResult> registroAIEPIResults = theQuery.list();

			return registroAIEPIResults;

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
	public Integer crearRegistroAIEPI(RegistroAIEPI registroAIEPI) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Integer id = (Integer) session.save(registroAIEPI);

			session.getTransaction().commit();
			
			return id;
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
	public RegistroAIEPI getRegistroAIEPI(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			RegistroAIEPI registroAIEPI = session.get(RegistroAIEPI.class, id);

			return registroAIEPI;

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
