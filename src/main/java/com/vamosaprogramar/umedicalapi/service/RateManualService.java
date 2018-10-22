package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.RateManual;

public interface RateManualService {
	
	public List<RateManual> getRateManuals();
	
	public RateManual getRateManual(int id);
	
	public Integer	addRateManual(RateManual rateManual);

	public void deleteRateManual(int id);

	public Integer uploadRateManualFile(MultipartFile rateManualFile, int id);

}
