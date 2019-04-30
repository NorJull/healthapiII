package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;
import com.vamosaprogramar.umedicalapi.service.ServicioRegistroHistoriaClinica;

@RestController
@RequestMapping("registroHistoriaClinicas")
public class ControladorRegistroHistoriaClinica {

	@Autowired
	private ServicioRegistroHistoriaClinica servicioRegistroHistoriaClinica;
	
	@GetMapping("/pacientes/{pacienteId}")
	public List<RegistroHistoriaClinicaResult> getMedicalRecordsByPatient(@PathVariable int pacienteId){
		return servicioRegistroHistoriaClinica.obtenerRegistroHistoriaClinicasPorPaciente(pacienteId);
	}
	
	@GetMapping("{id}")
	public RegistroHistoriaClinica getRegistroHistoriaClinica(@PathVariable int id){
		return servicioRegistroHistoriaClinica.obtenerRegistroHistoriaClinica(id);
	}
	
	@PostMapping()
	public void crearRegistroHistoriaClinica(@RequestBody RegistroHistoriaClinica registroHistoriaClinica) {
		servicioRegistroHistoriaClinica.crearRegistroHistoriaClinica(registroHistoriaClinica);
	}
}
