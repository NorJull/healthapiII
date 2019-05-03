package com.vamosaprogramar.umedicalapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Diagnostico;
import com.vamosaprogramar.umedicalapi.service.ServicioDiagnostico;

@RestController
@RequestMapping("diagnosticos")
public class ControladorDiagnostico {
	
	@Autowired
	private ServicioDiagnostico servicioDiagnostico;
	
	@GetMapping("{codigo}")
	public Diagnostico obtenerDiagnosticoPorCodigo(@PathVariable String codigo) {
		return servicioDiagnostico.obtenerDiagnosticoPorCodigo(codigo);
	}
	

}
