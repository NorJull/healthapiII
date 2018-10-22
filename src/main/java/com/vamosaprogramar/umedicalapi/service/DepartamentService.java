package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Departament;

public interface DepartamentService {


	public List<Departament> getDepartaments();
	
	public Departament getDepartament(int id);
}
