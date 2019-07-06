package com.vamosaprogramar.umedicalapi.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.service.ServicioRIPS;

@RestController
@RequestMapping("RIPSs")
public class ControladorRIPS {

	@Autowired
	private ServicioRIPS servicioRIPS;
	
	@GetMapping("/AP/{contratoId}/{factura}/{fechaInicial}/{fechaFinal}")
	public File obtenerAP(@PathVariable Integer contratoId,@PathVariable String factura,@PathVariable String fechaInicial,@PathVariable String fechaFinal) {
		try {
			return servicioRIPS.obtenerAP(contratoId,factura,fechaInicial, fechaFinal);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
