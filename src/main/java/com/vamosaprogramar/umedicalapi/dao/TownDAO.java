package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Town;

public interface TownDAO {

	public List<Town> getTowns();
	
	public Town getTown(int id);
}
