package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;
import com.vamosaprogramar.umedicalapi.service.ServicioRegistroAIEPI;

@RestController
@RequestMapping("registrosAIEPIs")
public class ControladorRegistroAIEPI {

	@Autowired
	private ServicioRegistroAIEPI servicioRegistroAIEPI;
	
	@GetMapping("/pacientes/{pacienteId}")
	public List<RegistroAIEPIResult> obtenerRegistroSAIEPIsPorPaciente(@PathVariable int pacienteId){
		return servicioRegistroAIEPI.obtenerRegistroSAIEPIsPorPaciente(pacienteId);
	}
	
	@GetMapping("{id}")
	public RegistroAIEPI getRegistroAIEPI(@PathVariable int id) {
		return servicioRegistroAIEPI.getRegistroAIEPI(id);
	}
	
	@PostMapping()
	public void crearRegistroAIEPI(@RequestBody RegistroAIEPI aiepi) {
		servicioRegistroAIEPI.crearRegistroAIEPI(aiepi);
	}
	
	
}
