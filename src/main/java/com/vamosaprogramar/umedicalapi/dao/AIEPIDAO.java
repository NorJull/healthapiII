package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;

public interface AIEPIDAO {

	List<AIEPI> getAIEPIsByPatient(int patientId);

	void addAIEPI(AIEPI aiepi);

}
