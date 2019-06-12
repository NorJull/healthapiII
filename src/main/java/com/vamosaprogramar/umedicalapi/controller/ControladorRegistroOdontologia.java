package com.vamosaprogramar.umedicalapi.controller;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;
import com.vamosaprogramar.umedicalapi.service.ServicioRegistroHistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registroOdontologias")
public class ControladorRegistroOdontologia {

	@Autowired
	private ServicioRegistroHistoriaClinica servicioRegistroHistoriaClinica;
	
	@GetMapping("/pacientes/{pacienteId}")
	public List<RegistroHistoriaClinicaResult> getMedicalRecordsByPatient(@PathVariable int pacienteId){
		return servicioRegistroHistoriaClinica.obtenerRegistroHistoriaClinicasPorPaciente(pacienteId);
	}
	
	@GetMapping("{id}")
	public RegistroHistoriaClinica getRegistroOdontologia(@PathVariable int id){
		return servicioRegistroHistoriaClinica.obtenerRegistroHistoriaClinica(id);
	}
	
	@PostMapping()
	public void crearRegistroOdontologia(@RequestBody RegistroHistoriaClinica registroHistoriaClinica) {
		servicioRegistroHistoriaClinica.crearRegistroHistoriaClinica(registroHistoriaClinica);
	}
}
