package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;

public interface AIEPIService {

	List<AIEPI> getAIEPIsByPatient(int patientId);

	void addAIEPI(AIEPI aiepi);

}
