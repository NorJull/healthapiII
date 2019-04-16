package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.AIEPIResult;
import com.vamosaprogramar.umedicalapi.service.AIEPIService;

@RestController
@RequestMapping("AIEPIs")
public class AIEPIController {

	@Autowired
	private AIEPIService aiepiService;
	
	@GetMapping("/patients/{patientId}")
	public List<AIEPIResult> getAIEPIsByPatient(@PathVariable int patientId){
		return aiepiService.getAIEPIsByPatient(patientId);
	}
	
	@GetMapping("{id}")
	public AIEPI getAIEPI(@PathVariable int id) {
		return aiepiService.getAIEPI(id);
	}
	
	@PostMapping()
	public void addAIEPI(@RequestBody AIEPI aiepi) {
		aiepiService.addAIEPI(aiepi);
	}
	
	
}
