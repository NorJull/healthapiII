package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.ContractDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.service.async.ContractServiceAsync;

@Service
public class ContractServiceImpl implements ContractService {

	@Autowired
	private ContractDAO contractDAO;
	
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private ContractServiceAsync contractServiceAsyn;
	
	@Override
	public List<Contract> getContracts() {
		
		return contractDAO.getContracts();
	}

	@Override
	public Contract getContract(int id) {
	
		return contractDAO.getContract(id);
	}

	@Override
	public Integer addContract(Contract contract) {

		return contractDAO.addContract(contract);
	}

	@Override
	public Integer uploadContractFile(MultipartFile contractFile, int id){
		
			
		String uploadFolder = ".//src//main//resources//myFiles//";
		
		try{
			byte[] bytes = contractFile.getBytes();	

			Path path = Paths.get(uploadFolder + contractFile.getOriginalFilename() );
			
			Files.write(path, bytes);
			
			FileReader fileReader = new FileReader(uploadFolder + contractFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			
			
			Process process = new  Process(1, "PROCEDIMIENTOS DE UN CONTRATO", 'E', LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			contractServiceAsyn.addProcedureTypes(bufferedReader,id, processId, totalRows);
			
			return processId;
			
		}catch (Exception e) {
			e.printStackTrace();
		}	

			

		return null;
	
			
		
	}

	@Override
	public List<Contract> getContractsByHealthEntity(int healthEntityId) {
		
		return contractDAO.getContractsByHealthEntity(healthEntityId);
	}

	@Override
	public List<ProcedureType> getProcedureTypes(int contractId) {
		
		return contractDAO.getProcedureTypes(contractId);
	}

	@Override
	public Integer uploadPatientsFile(MultipartFile patientsFile, int contractId) {
				
		try{
			byte[] bytes = patientsFile.getBytes();	

			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + patientsFile.getOriginalFilename() );
			
			Files.write(path, bytes);
			
			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + patientsFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			
			
			Process process = new  Process(1, GeneralConstants.PACIENTES_DE_UN_CONTRATO, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			contractServiceAsyn.addPatients(bufferedReader,contractId, processId, totalRows);
			
			return processId;
			
		}catch (Exception e) {
			e.printStackTrace();
		}	

			

		return null;
	
	}

	@Override
	public List<Patient> getPatients(int id) {
		
		return contractDAO.getPatients(id);
	}

}
