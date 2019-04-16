package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.AIEPIResult;

public interface AIEPIService {

	List<AIEPIResult> getAIEPIsByPatient(int patientId);

	void addAIEPI(AIEPI aiepi);

	AIEPI getAIEPI(int id);

}
