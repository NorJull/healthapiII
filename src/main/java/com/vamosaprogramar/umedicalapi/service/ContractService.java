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

	public Integer uploadContractFile(MultipartFile contractFile, int id);

	public List<Contract> getContractsByHealthEntity(int healthEntityId);

	public List<ProcedureType> getProcedureTypes(int contractId);

	public Integer uploadPatientsFile(MultipartFile patientsFile, int id);

	public List<Patient> getPatients(int id);
	
	

}
