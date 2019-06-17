package com.vamosaprogramar.umedicalapi.controller;

import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;
import com.vamosaprogramar.umedicalapi.service.ServicioRegistroOdontologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registroOdontologias")
public class ControladorRegistroOdontologia {

	@Autowired
	private ServicioRegistroOdontologia servicioRegistroOdontologia;
	
	@GetMapping("/pacientes/{pacienteId}")
	public List<RegistroOdontologiaResult> getRegistroOdontologiaResultPorPaciente(@PathVariable int pacienteId){
		return servicioRegistroOdontologia.obtenerRegistroOdontologiaResultPorPaciente(pacienteId);
	}
	
	@GetMapping("{id}")
	public RegistroOdontologia getRegistroOdontologia(@PathVariable int id){
		return servicioRegistroOdontologia.obtenerRegistroOdontologia(id);
	}
	
	@PostMapping()
	public void crearRegistroOdontologia(@RequestBody RegistroOdontologia registroOdontologia) {
		servicioRegistroOdontologia.crearRegistroHistoriaClinica(registroOdontologia);
	}
	
	@GetMapping("/odontograma/{pacienteId}")
	public String obtenerOdontograma(@PathVariable int pacienteId) {
		return servicioRegistroOdontologia.obtenerOdontograma(pacienteId);
	}
}
