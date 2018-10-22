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

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.service.SpecialityService;


@RestController
@RequestMapping("specialities")
public class SpecialityController {

	@Autowired
	private SpecialityService specialityService;
	
	@GetMapping()
	public List<Speciality> getSpecialities(){
					
		return specialityService.getSpecialities();
		
	}
	
	@GetMapping("{id}")
	public Speciality getSpeciality(@PathVariable int id) {
		return specialityService.getSpeciality(id);
	}
	
	@GetMapping("/{id}/procedureTypes")
	public List<ProcedureType> getProcedureTypes(@PathVariable int id){
		
		return specialityService.getProcedureTypes(id);
	}
	
	@PostMapping()
	public Integer addSpeciality(@RequestBody Speciality speciality) {
	
		return specialityService.addSpeciality(speciality);
	}
	
	@PostMapping(path = "/{id}/procedureTypes/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadProcedureTypesFile(@RequestParam("file") MultipartFile procedureTypesFile,@PathVariable int id){
		
		//speciality procedures
		if(procedureTypesFile.isEmpty()) {
			
			return null;
		}
		
		Integer processId = specialityService.uploadProcedureTypesFile(procedureTypesFile, id);
		
		return processId;
	}
	
}
