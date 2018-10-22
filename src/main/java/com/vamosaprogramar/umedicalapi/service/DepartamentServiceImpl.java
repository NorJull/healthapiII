package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.DepartamentDAO;
import com.vamosaprogramar.umedicalapi.entity.Departament;

@Service 
public class DepartamentServiceImpl implements DepartamentService {

	@Autowired
	private DepartamentDAO departamentDAO;
	
	
	@Override
	public List<Departament> getDepartaments() {
			return departamentDAO.getDepartaments();
	}

	@Override
	public Departament getDepartament(int id) {
		return departamentDAO.getDepartament(id);
	}

}
