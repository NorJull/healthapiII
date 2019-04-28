package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.service.ServicioTipoProcedimiento;

@RestController
@RequestMapping("tiposProcedimientos")
public class ControladorTipoProcedimiento {
	
	@Autowired
	private ServicioTipoProcedimiento servicioTipoProcedimiento;
		
	
	@GetMapping
	public List<TipoProcedimiento> getProceduresType(){
		return servicioTipoProcedimiento.getProceduresType();
	}
	
	
	@GetMapping("{id}")
	public TipoProcedimiento getProcedureType(@PathVariable int id) {
		return servicioTipoProcedimiento.getProceduresType(id);
	} 
	

	@PostMapping(path = "/subirArchivo", consumes = { "multipart/form-data" })
	public Integer subirArchivoTiposProcedimientos(@RequestParam("file") MultipartFile archivoTiposProcedimientos){

		if(archivoTiposProcedimientos.isEmpty()) {
			return null;
		}		
		Integer procesoId = servicioTipoProcedimiento.subirArchivoTiposProcedimientos(archivoTiposProcedimientos);
		return procesoId;
	}
	
	@PutMapping("{id}")
	public void updateProcedureType(@RequestBody TipoProcedimiento procedureType, @PathVariable int id) {
		
		servicioTipoProcedimiento.updateProcedureType(procedureType,id);
	}
	
	
}
