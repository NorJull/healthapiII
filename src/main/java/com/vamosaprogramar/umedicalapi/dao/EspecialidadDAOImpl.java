package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class EspecialidadDAOImpl implements EspecialidadDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Especialidad> obtenerEspecialidades() {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery("from Especialidad");
			
			List<Especialidad> especialidades = theQuery.list();
			
			session.getTransaction().commit();

			return especialidades;

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
	public Especialidad obtenerEspecialidad(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Especialidad especialidad = session.get(Especialidad.class, id);
			
			session.getTransaction().commit();

			return especialidad;

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
	public Integer crearEspecialidad(Especialidad especialidad) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Integer especialidadId = (Integer) session.save(especialidad);
			
			session.getTransaction().commit();

			return especialidadId;

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
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int especialidadId) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM TipoProcedimiento p JOIN p.especialidades sp WHERE sp.id= :ID");
			
			theQuery.setParameter("ID", especialidadId);
			
			List<TipoProcedimiento> tiposProcedimientos = theQuery.list();
			
			session.getTransaction().commit();
			
			return tiposProcedimientos;
			
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
	public boolean existeEspecialidad(int especialidadId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Especialidad especialidad = session.get(Especialidad.class, especialidadId);
			
			session.getTransaction().commit();

			if (especialidad == null) {
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
	public void asociarTipoProcedimento(int especialidadId, String cup, Session session) throws ProcedureTypeDoesNotExist {
		
		Query procedureTypeQuery = session.createQuery("From TipoProcedimiento where cup=:cupId");
		procedureTypeQuery.setParameter("cupId", cup);
		
		TipoProcedimiento tipoProcedimiento = (TipoProcedimiento) procedureTypeQuery.uniqueResult();

		// Valida si el procedimiento existe.
		if (tipoProcedimiento == null) {
			throw new ProcedureTypeDoesNotExist(cup);
		}
		
		Especialidad especialidad = session.get(Especialidad.class, especialidadId);
		
		especialidad.addProcedureType(tipoProcedimiento);
		
	}

	@Override
	public List<ApplicationUser> obtenerUsuarios(int id) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM ApplicationUser p JOIN p.specialities sp WHERE sp.id= :ID");
			
			theQuery.setParameter("ID", id);
			
			List<ApplicationUser> applicationUsers = theQuery.list();
			
			session.getTransaction().commit();
			
			return applicationUsers;
			
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
