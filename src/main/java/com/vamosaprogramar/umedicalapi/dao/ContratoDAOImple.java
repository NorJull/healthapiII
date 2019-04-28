package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;
import com.vamosaprogramar.umedicalapi.exception.PatientDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

@Repository
public class ContratoDAOImple implements ContratoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Contrato> obtenerContratos() {

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();

			Query theQuery = session.createQuery("from Contrato");

			List<Contrato> contratos = theQuery.list();

			session.getTransaction().commit();

			return contratos;

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
	public Contrato obtenerContrato(int id) {

		Session session = null;
		try {

			session = sessionFactory.openSession();
			session.beginTransaction();

			Contrato contrato = session.get(Contrato.class, id);

			session.getTransaction().commit();

			return contrato;
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
	public Integer crearContrato(Contrato contrato) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
		
			if( contrato.getHealthEntity() != null) {
				HealthEntity healthEntity = session.get(HealthEntity.class, contrato.getHealthEntity().getId());
				contrato.setHealthEntity(healthEntity);
				healthEntity.addContract(contrato);
			}
					
			if (contrato.getRateManual() != null) {

				ManualTarifario manualTarifario = session.get(ManualTarifario.class, contrato.getRateManual().getId());

				contrato.setRateManual(manualTarifario);

			}
						
			Integer contratoId = (Integer) session.save(contrato);

			session.getTransaction().commit();

			return contratoId;
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
	public List<Contrato> obtenerContratosPorEntidad(int healthEntityId) {

		Session session = null;
	
		try {

			session = sessionFactory.openSession();

			session.beginTransaction();

			Query theQuery = session.createQuery("FROM Contrato WHERE healthEntity.id= :ID");
			
			theQuery.setParameter("ID", healthEntityId);
		
			List<Contrato> contratos = theQuery.list();

			session.getTransaction().commit();

			return contratos;

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
	public boolean existeContrato(int contratoId) {
		Session session = null;

		try {
			session = sessionFactory.openSession();

			session.beginTransaction();

			Contrato contract = session.get(Contrato.class, contratoId);

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
	public void asociarTipoProcedimiento(int contratoId, String line, Session session) throws ProcedureTypeDoesNotExist {

		Query tipoProcedimientoQuery = session.createQuery("From TipoProcedimiento where cup=:cupId");
		tipoProcedimientoQuery.setParameter("cupId", line);
		TipoProcedimiento tipoProcedimiento = (TipoProcedimiento) tipoProcedimientoQuery.uniqueResult();

		// Valida si el procedimiento existe.
		if (tipoProcedimiento == null) {
			throw new ProcedureTypeDoesNotExist(line);
		}

		Contrato contrato = session.get(Contrato.class, contratoId);

		contrato.addProcedureType(tipoProcedimiento);
	}

	@Override
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int contratoId) {

		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("SELECT p FROM TipoProcedimiento p JOIN p.contractos cs WHERE cs.id= :ID");
			
			theQuery.setParameter("ID", contratoId);
			
			List<TipoProcedimiento> procedureTypes = theQuery.list();	
			
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
	public int addPatient(int contratoId, String document, String documentType, Session session) throws PatientDoesNotExist {

		Query theQuery = session.createQuery("From Patient where document= :patientDocument and documentType= :documentType");

		theQuery.setParameter("patientDocument", document);
		theQuery.setParameter("documentType", documentType);

		Patient patient = (Patient) theQuery.uniqueResult();

		if (patient == null) {
			throw new PatientDoesNotExist(document,documentType);
		}

		patient.setContractId(contratoId);
		
		return patient.getId();

	}

	@Override
	public List<Patient> getPatients(int id) {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Query theQuery = session.createQuery("From Patient where contractId = :ID");
			
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

	@Override
	public void desasociarTiposProcedimientos(int contratoId) {
		Session session = null;
		

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM contrato_tipo_procedimeinto cpt WHERE cpt.contrato_id = :contractId");
			sqlQuery.setParameter("contractId", contratoId);
			
			sqlQuery.executeUpdate();
			
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
	public void updateContract(Contrato contarto) {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			Contrato contratoPersistente = session.get(Contrato.class, contarto.getId());
			if(contratoPersistente != null) {
			contratoPersistente.setDescripcion(contarto.getDescripcion());
			contratoPersistente.setFechaInicial(contarto.getFechaInicial());
			contratoPersistente.setFechaFinal(contarto.getFechaFinal());
			contratoPersistente.setPorcentajeManualTarifario(contarto.getPorcentajeManualTarifario());
			contratoPersistente.setValor(contarto.getValor());
			}
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
