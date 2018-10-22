package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Departament;

public interface DepartamentDAO {

	public List<Departament> getDepartaments();
	
	public Departament getDepartament(int id);
	
}
