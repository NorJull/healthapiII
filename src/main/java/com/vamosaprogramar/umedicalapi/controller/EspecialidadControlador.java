package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;
import com.vamosaprogramar.umedicalapi.service.ServicioEspecialidad;


@RestController
@RequestMapping("especialidades")
public class EspecialidadControlador {

	@Autowired
	private ServicioEspecialidad servicioEspecialidad;
	
	@GetMapping()
	public List<Especialidad> getSpecialities(){
					
		return servicioEspecialidad.obtenerEspecialidades();
		
	}
	
	@GetMapping("{id}")
	public Especialidad getSpeciality(@PathVariable int id) {
		return servicioEspecialidad.obtenerEspecialidad(id);
	}
	
	@GetMapping("/{id}/tiposProcedimientos")
	public List<TipoProcedimiento> getProcedureTypes(@PathVariable int id){
		
		return servicioEspecialidad.obtenerTiposProcedimientos(id);
	}
	
	@GetMapping("/{id}/usuarios")
	public List<ApplicationUser> geUsers(@PathVariable int id){
		
		return servicioEspecialidad.obtenerUsuarios(id);
	}
	
	
	@PostMapping()
	public Integer addSpeciality(@RequestBody Especialidad speciality) {
	
		return servicioEspecialidad.crearEspecialidad(speciality);
	}
	
	@PostMapping(path = "/{id}/tiposProcedimientos/subirArchivo", consumes = { "multipart/form-data" })
	public Integer subirArchivoTiposProcedimientos(@RequestParam("file") MultipartFile archivoTiposProcedimientos,@PathVariable int id){
	
		if(archivoTiposProcedimientos.isEmpty()) {
			
			return null;
		}
		
		return servicioEspecialidad.subirArchivoTiposProcedimientos(archivoTiposProcedimientos, id);
		
	}
	
}
