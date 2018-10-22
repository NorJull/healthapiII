package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Town;
import com.vamosaprogramar.umedicalapi.service.TownService;

@RestController
@RequestMapping("towns")
public class TownController {

	
	@Autowired
	private TownService townService;

	@GetMapping()
	public List<Town> getTowns(){
		return townService.getTowns();
	}

	@GetMapping("{id}")
	public Town getTown(@PathVariable int id) {
		return townService.getTown(id);
	}
	
}
