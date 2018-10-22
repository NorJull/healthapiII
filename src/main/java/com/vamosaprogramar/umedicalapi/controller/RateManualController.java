package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedureRate;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRateId;
import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.RateManual;
import com.vamosaprogramar.umedicalapi.service.ProcedureRateService;
import com.vamosaprogramar.umedicalapi.service.ProcedureRateServiceImpl;
import com.vamosaprogramar.umedicalapi.service.RateManualService;

@RestController
@RequestMapping("rateManuals")
public class RateManualController {
	
	@Autowired
	private RateManualService rateManualService;
	
	@Autowired
	private ProcedureRateService procedureRateService;
	
	@GetMapping()
	public List<RateManual> getRateManuals(){
		return rateManualService.getRateManuals();
	}
	
	
	@GetMapping("{id}")
	public RateManual getRateManual(@PathVariable int id) {
		return rateManualService.getRateManual(id);
	}
	
	@GetMapping("{manualId}/procedureRates")
	public List<ProcedureRate> getProcedureRatesByManual(@PathVariable int manualId){
		List<ProcedureRate> p = procedureRateService.getProcedureRatesByManual(manualId);
		System.out.println(p);
		return p;
	}
	
	@PostMapping()
	public Integer addRateManual(@RequestBody RateManual rateManual) {
		return rateManualService.addRateManual(rateManual);
	}
	
	@PostMapping(path = "{id}/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadRateManualFile(@RequestParam("file") MultipartFile rateManualFile,@PathVariable int id) {
		
		System.out.println("Cotrolador.uploadRateManualFile");
		
		
		if(rateManualFile.isEmpty()) {
		return null;
		}
		Integer processId = rateManualService.uploadRateManualFile(rateManualFile, id);
		
		return processId;
	}
	
	@DeleteMapping("{id}")
	public void deleteRateManual(@PathVariable int id) {
		rateManualService.deleteRateManual(id);
	}
	
	/********************************************************
	 * Servicios relacionados con ProcedureRate  
	 * *****************************************************/
	
	@PostMapping("{test}")
	public void addProcedureRate() {
		
		ProcedureType pty = new ProcedureType(2, "Soy un Cup de prueba", "Esta es la descripción del PTY");
		RateManual rm    = new RateManual(2, "Soy el Manual");
		
		ProcedureRateId prid = new ProcedureRateId(rm, pty); 
	
		ProcedureRate pr  = new ProcedureRate(prid, 15000);
		
		procedureRateService.addProcedureRate(pr);
	}
	
	@GetMapping("/test")
	public List<ProcedureRate> getProcedureRatess() {
		
		
		return procedureRateService.getProcedureRates();
	}
	
	
}
