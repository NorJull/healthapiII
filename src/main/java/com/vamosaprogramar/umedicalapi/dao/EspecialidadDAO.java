package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface EspecialidadDAO {
	
public List<Especialidad> obtenerEspecialidades();
	
	public Especialidad obtenerEspecialidad(int id);
	
	public Integer crearEspecialidad(Especialidad speciality);
	
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int specialityId);

	public boolean existeEspecialidad(int specialityId);

	public void asociarTipoProcedimento(int specialityId, String cup, Session session) throws ProcedureTypeDoesNotExist;

	public List<ApplicationUser> obtenerUsuarios(int id);
	
}
