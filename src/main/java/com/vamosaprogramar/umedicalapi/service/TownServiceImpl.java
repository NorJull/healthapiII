package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.TownDAO;
import com.vamosaprogramar.umedicalapi.entity.Town;

@Service
public class TownServiceImpl implements TownService {

	@Autowired
	private TownDAO townDAO;
	
	
	@Override
	public List<Town> getTowns() {

		return townDAO.getTowns();
	}

	@Override
	public Town getTown(int id) {
		// TODO Auto-generated method stub
		return townDAO.getTown(id);
	}

}
