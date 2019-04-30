package com.vamosaprogramar.umedicalapi.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;

@Repository
public class RegistroHistoriaClinicaDAOImpl implements RegistroHistoriaClinicaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RegistroHistoriaClinicaResult> obtenerRegistroHistoriaClinicasPorPaciente(int pacienteId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery(
					"select mr.id as id, mr.pacienteId as pacienteId, mr.fechaEntrada as fecha, mr.horaEntrada as hora, mr.esParticular as esParticular, mr.motivoConsulta as motivoConsulta from RegistroHistoriaClinica mr where mr.pacienteId = :pacienteId");
			theQuery.setParameter("pacienteId", pacienteId);

			theQuery.setResultTransformer(Transformers.aliasToBean(RegistroHistoriaClinicaResult.class));

			List<RegistroHistoriaClinicaResult> registroHistoriaClinicaResults = theQuery.list();

			return registroHistoriaClinicaResults;

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
	public void crearRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			session.save(registroHistoriaClinica);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}

	}

	@Override
	public RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			RegistroHistoriaClinica registroHistoriaClinica = (RegistroHistoriaClinica) session.get(RegistroHistoriaClinica.class, id);

			return registroHistoriaClinica;

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
