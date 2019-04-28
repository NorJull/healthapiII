package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.HealthEntity;
import com.vamosaprogramar.umedicalapi.service.HealthEntityService;

@RestController
@RequestMapping("healthEntities")
public class HealthEntityController {
	
	@Autowired
	private HealthEntityService healthEntityService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping()
	public List<HealthEntity> getHealthEntities(){
		return healthEntityService.getHealthEntities();
	}
	
	@GetMapping("{healthEntityId}/contracts")
	public List<Contrato> getContractsByHealthEntity(@PathVariable int healthEntityId){
		return healthEntityService.getContractsByHealthEntity(healthEntityId);
	}
	
		
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("{id}")
	public HealthEntity geHealthEntity(@PathVariable int id) {
		
		return healthEntityService.getHealthEntity(id);
	
	}	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping()
	public void addHealthEntity(@RequestBody HealthEntity healthEntity) {
		healthEntityService.addHealthEntity(healthEntity);
	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Authorization", "Content-Type","Access-Control-Allow-Origin"})
	@PutMapping("{id}")
	public void updateHealthEntity(@RequestBody HealthEntity healthEntity,@PathVariable int id) {
		healthEntityService.updateHealthEntity(healthEntity, id);

	}
	
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Authorization", "Content-Type","Access-Control-Allow-Origin"})
	@DeleteMapping("{id}")
	public void deleteHealthEnity(@PathVariable int id) {
		healthEntityService.deleteHealthEnity(id);
  
	}
	 
}
