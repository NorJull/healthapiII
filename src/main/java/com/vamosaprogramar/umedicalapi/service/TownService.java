package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Town;

public interface TownService {
	public List<Town> getTowns();
	
	public Town getTown(int id);
}
