package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.AIEPIDAO;
import com.vamosaprogramar.umedicalapi.entity.AIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.AIEPIResult;

@Service
public class AIEPIServiceImpl implements AIEPIService {

	@Autowired
	private AIEPIDAO aiepiDAO;
	
	@Override
	public List<AIEPIResult> getAIEPIsByPatient(int patientId) {
		return aiepiDAO.getAIEPIsByPatient(patientId);
	}

	@Override
	public void addAIEPI(AIEPI aiepi) {
		aiepiDAO.addAIEPI(aiepi);
	}

	@Override
	public AIEPI getAIEPI(int id) {
		return aiepiDAO.getAIEPI(id);
	}

}
