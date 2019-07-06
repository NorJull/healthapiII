package com.vamosaprogramar.umedicalapi.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Resource> obtenerAP(@PathVariable Integer contratoId,@PathVariable String factura,@PathVariable String fechaInicial,@PathVariable String fechaFinal) {
		try {
			File file = servicioRIPS.obtenerAP(contratoId,factura,fechaInicial, fechaFinal);
			Resource fileSystemResource = new FileSystemResource(file);
			 return ResponseEntity.ok()
	                    .contentType(MediaType.MULTIPART_FORM_DATA)
	                    .body(fileSystemResource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
