package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Departament;
import com.vamosaprogramar.umedicalapi.service.DepartamentService;

@RestController
@RequestMapping("departaments")
public class DepartamentController {
	
	@Autowired
	private DepartamentService departamentService;
	
	@GetMapping("hello")
	public String sayHello() {
		return "Hello Nor";
	}
	
	@GetMapping()
	public List<Departament> getDepartaments(){
		return departamentService.getDepartaments();
	}
	
	@GetMapping("{id}")
	public Departament getDepartament(@PathVariable int id) {
		return departamentService.getDepartament(id);
	}
}

