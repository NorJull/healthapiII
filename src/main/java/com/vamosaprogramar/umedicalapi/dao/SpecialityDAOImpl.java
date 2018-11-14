package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class SpecialityDAOImpl implements SpecialityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Speciality> getSpecialities() {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery("from Speciality");
			
			List<Speciality> specialities = theQuery.list();
			
			session.getTransaction().commit();

			return specialities;

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
	public Speciality getSpeciality(int id) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Speciality speciality = session.get(Speciality.class, id);
			
			session.getTransaction().commit();

			return speciality;

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
	public Integer addSpeciality(Speciality speciality) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Integer specialityId = (Integer) session.save(speciality);
			
			session.getTransaction().commit();

			return specialityId;

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
	public List<ProcedureType> getProcedureTypes(int specialityId) {
		Session session = null;
		
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM ProcedureType p JOIN p.specialities sp WHERE sp.id= :ID");
			
			theQuery.setParameter("ID", specialityId);
			
			List<ProcedureType> procedureTypes = theQuery.list();
			
			session.getTransaction().commit();
			
			return procedureTypes;
			
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
	public boolean specialityExist(int specialityId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Speciality speciality = session.get(Speciality.class, specialityId);
			
			session.getTransaction().commit();

			if (speciality == null) {
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
	public void addProcedureType(int specialityId, String cup, Session session) throws ProcedureTypeDoesNotExist {
		
		Query procedureTypeQuery = session.createQuery("From ProcedureType where cup=:cupId");
		procedureTypeQuery.setParameter("cupId", cup);
		ProcedureType procedureType = (ProcedureType) procedureTypeQuery.uniqueResult();

		// Valida si el procedimiento existe.
		if (procedureType == null) {
			throw new ProcedureTypeDoesNotExist(cup);
		}
		
		Speciality speciality = session.get(Speciality.class, specialityId);
		speciality.addProcedureType(procedureType);
		
	
	}

	@Override
	public List<ApplicationUser> getApplicationUsers(int id) {
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
