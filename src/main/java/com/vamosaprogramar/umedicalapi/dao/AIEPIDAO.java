package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.AIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.AIEPIResult;

public interface AIEPIDAO {

	List<AIEPIResult> getAIEPIsByPatient(int patientId);

	void addAIEPI(AIEPI aiepi);

	AIEPI getAIEPI(int id);

}
