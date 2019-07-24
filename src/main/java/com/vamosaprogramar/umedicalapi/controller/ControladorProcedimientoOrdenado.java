package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.service.ServicioProcedimientoOrdenado;

@RestController
@RequestMapping("procedimientosOrdenados")
public class ControladorProcedimientoOrdenado {

	@Autowired
	private ServicioProcedimientoOrdenado servicioProcedimientoOrdenado;
	
	@GetMapping("/pendientes/{documento}/{tipoDocumento}")
	public List<ProcedimientoOrdenado> obtenerProcedimientosPendientes(@PathVariable String documento, @PathVariable String tipoDocumento){
		return servicioProcedimientoOrdenado.obtenerProcedimientosOrdenados(documento, tipoDocumento);
	}
}
