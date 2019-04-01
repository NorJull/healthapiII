package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.RateManual;
import com.vamosaprogramar.umedicalapi.exception.PatientDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class ContractDAOImple implements ContractDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Contract> getContracts() {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery("from Contract");

			List<Contract> contracts = theQuery.list();

			session.getTransaction().commit();

			return contracts;

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
	public Contract getContract(int id) {

		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			Contract contract = session.get(Contract.class, id);

			session.getTransaction().commit();

			return contract;
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
	public Integer addContract(Contract contract) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			System.out.println("Esta es mi entidad: "+contract.getHealthEntity());
			
			if( contract.getHealthEntity() != null) {
				HealthEntity healthEntity = session.get(HealthEntity.class, contract.getHealthEntity().getId());
				contract.setHealthEntity(healthEntity);
				healthEntity.addContract(contract);
			}
					
			if (contract.getRateManual() != null) {

				RateManual rateManual = session.get(RateManual.class, contract.getRateManual().getId());

				contract.setRateManual(rateManual);

			}
						
			Integer contractId = (Integer) session.save(contract);

			session.getTransaction().commit();

			return contractId;
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
	public List<Contract> getContractsByHealthEntity(int healthEntityId) {

		Session session = null;
	
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("FROM Contract WHERE healthEntity.id= :ID");
			
			theQuery.setParameter("ID", healthEntityId);
		
			List<Contract> contracts = theQuery.list();

			session.getTransaction().commit();

			return contracts;

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
	public boolean contractExist(int contractId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Contract contract = session.get(Contract.class, contractId);

			session.getTransaction().commit();

			if (contract == null) {
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
	public void addProcedureType(int contractId, String line, Session session) throws ProcedureTypeDoesNotExist {

		Query procedureTypeQuery = session.createQuery("From ProcedureType where cup=:cupId");
		procedureTypeQuery.setParameter("cupId", line);
		ProcedureType procedureType = (ProcedureType) procedureTypeQuery.uniqueResult();

		// Valida si el procedimiento existe.
		if (procedureType == null) {
			throw new ProcedureTypeDoesNotExist(line);
		}

		Contract contract = session.get(Contract.class, contractId);

		contract.addProcedureType(procedureType);
	}

	@Override
	public List<ProcedureType> getProcedureTypes(int contractId) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM ProcedureType p JOIN p.contracts cs WHERE cs.id= :ID");
			
			theQuery.setParameter("ID", contractId);
			
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
	public int addPatient(int contractId, String document, String documentType, Session session) throws PatientDoesNotExist {

		Query theQuery = session.createQuery("From Patient where document= :patientDocument and documentType= :documentType");

		theQuery.setParameter("patientDocument", document);
		theQuery.setParameter("documentType", documentType);

		Patient patient = (Patient) theQuery.uniqueResult();

		if (patient == null) {
			throw new PatientDoesNotExist(document,documentType);
		}

		patient.setContractId(contractId);
		
		return patient.getId();

	}

	@Override
	public List<Patient> getPatients(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM Patient p JOIN p.contracts cs WHERE cs.id= :ID");
			
			theQuery.setParameter("ID", id);
						
			List<Patient> patients = theQuery.list();			
						
			session.getTransaction().commit();

			return patients;

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
