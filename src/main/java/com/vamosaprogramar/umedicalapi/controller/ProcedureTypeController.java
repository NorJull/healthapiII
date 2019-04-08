package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.service.ProcedureTypeService;

@RestController
@RequestMapping("procedureTypes")
public class ProcedureTypeController {
	
	@Autowired
	private ProcedureTypeService procedureTypeService;
	
	
	
	@GetMapping
	public List<ProcedureType> getProceduresType(){
		return procedureTypeService.getProceduresType();
	}
	
	
	@GetMapping("{id}")
	public ProcedureType getProcedureType(@PathVariable int id) {
		return procedureTypeService.getProceduresType(id);
	} 
	

	@PostMapping(path = "/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadProcedureTypesFile(@RequestParam("file") MultipartFile procedureTypeFile){

		
		if(procedureTypeFile.isEmpty()) {
			return null;
		}
		
		Integer processId = procedureTypeService.uploadProcedureTypeFile(procedureTypeFile);
	
		return processId;
		
	}
	
	@PutMapping("{id}")
	public void updateProcedureType(@RequestBody ProcedureType procedureType, @PathVariable int id) {
		
		procedureTypeService.updateProcedureType(procedureType,id);
	}
	
	
}
