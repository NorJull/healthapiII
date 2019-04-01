package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Contract;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.service.ContractService;

@RestController
@RequestMapping("contracts")
public class ContractController {

	@Autowired
	private ContractService contractService;

	@GetMapping()
	public List<Contract> getContracts() {

		return contractService.getContracts();
	}

	@GetMapping("{id}")
	public Contract getContract(@PathVariable int id) {

		Contract c = contractService.getContract(id);
		return c;
	}

	@GetMapping("/{id}/procedureTypes")
	public List<ProcedureType> getProcedureTypes(@PathVariable int id) {

		return contractService.getProcedureTypes(id);
	}

	@GetMapping("/{id}/patients")
	public List<Patient> getPatients(@PathVariable int id) {

		return contractService.getPatients(id);
	}

	@PostMapping()
	public Integer addContract(@RequestBody Contract contract) {

		return contractService.addContract(contract);
	}

	@PostMapping(path = "/{id}/procedureTypes/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadProcedureTypesFile(@RequestParam("file") MultipartFile procedureTypesFile,
			@PathVariable int id) {

		// contract procedures
		if (procedureTypesFile.isEmpty()) {

			return null;
		}

		Integer processId = contractService.uploadContractFile(procedureTypesFile, id);

		return processId;
	}

	@PostMapping(path = "/{id}/patients/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadPatientsFile(@RequestParam("file") MultipartFile PatientsFile, @PathVariable int id) {

		// contract procedures
		if (PatientsFile.isEmpty()) {

			return null;
		}

		Integer processId = contractService.uploadPatientsFile(PatientsFile, id);

		return processId;
	}

}
