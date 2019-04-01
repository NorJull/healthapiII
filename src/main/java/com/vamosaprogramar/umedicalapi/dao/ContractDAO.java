package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.exception.PatientDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface ContractDAO {

	public List<Contract> getContracts();

	public Contract getContract(int id);

	public Integer addContract(Contract contract);

	public List<Contract> getContractsByHealthEntity(int healthEntityId);

	public boolean contractExist(int contractId);

	public void addProcedureType(int contractId, String line, Session session) throws ProcedureTypeDoesNotExist;
	
		
	public List<ProcedureType> getProcedureTypes(int contractId);

	public int addPatient(int contractId, String document, String documentType, Session session) throws PatientDoesNotExist;

	public List<Patient> getPatients(int id);
	
	
	

}
