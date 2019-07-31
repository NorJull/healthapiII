package com.vamosaprogramar.umedicalapi.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
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

	@PostMapping(path = "/subirArchivo/{id}/{tipoHistoria}", consumes = { "multipart/form-data" })
	public void subirResultados(@RequestParam("file") MultipartFile resultadoProcedimiento, @PathVariable int id,  @PathVariable String tipoHistoria) {
		 servicioProcedimientoOrdenado.subirResultados(resultadoProcedimiento, id, tipoHistoria);
	}
	
	@GetMapping("/descargarArchivo/{nombreArchivo}")
	public ResponseEntity<Resource> obtenerAC(@PathVariable String nombreArchivo) {
	
		try {
			File file = new File(GeneralConstants.BACTE_UPLOAD_FOLDER +nombreArchivo);
			Resource fileSystemResource = new FileSystemResource(file);
			 return ResponseEntity.ok()
	                    .contentType(MediaType.MULTIPART_FORM_DATA)
	                    .body(fileSystemResource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; 
	}
}
