package com.vamosaprogramar.umedicalapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;

public interface ContractService {

	public List<Contract> getContracts();

	public Contract getContract(int id);

	public Integer addContract(Contract contract);

	public Integer uploadProcedureTypesFile(MultipartFile contractFile, int contractId);

	public List<Contract> getContractsByHealthEntity(int healthEntityId);

	public List<ProcedureType> getProcedureTypes(int contractId);

	public Integer uploadPatientsFile(MultipartFile patientsFile, int contractId);

	public List<Patient> getPatients(int id);
	
	

}
