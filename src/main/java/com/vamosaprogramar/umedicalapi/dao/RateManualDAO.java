package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.RateManual;

public interface RateManualDAO {
	
	public List<RateManual> getRateManuals();
	
	public RateManual getRateManual(int id);
	
	public Integer	addRateManual(RateManual rateManual);

	public void deleteRateManual(int id);

	public boolean rateManualExist(int id);
}
