package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;

public interface ServicioEspecialidad {

	public List<Especialidad> obtenerEspecialidades();
	
	public Especialidad obtenerEspecialidad(int id);
	
	public Integer crearEspecialidad(Especialidad speciality);
	
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int specialityId);
	
	public Integer subirArchivoTiposProcedimientos(MultipartFile procedureTypesFile, int specialityId);

	public List<ApplicationUser> obtenerUsuarios(int id);
	
	
}
