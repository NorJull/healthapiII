package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.AIEPIDAO;
import com.vamosaprogramar.umedicalapi.entity.AIEPI;

@Service
public class AIEPIServiceImpl implements AIEPIService {

	@Autowired
	private AIEPIDAO aiepiDAO;
	
	@Override
	public List<AIEPI> getAIEPIsByPatient(int patientId) {
		return aiepiDAO.getAIEPIsByPatient(patientId);
	}

	@Override
	public void addAIEPI(AIEPI aiepi) {
		aiepiDAO.addAIEPI(aiepi);
	}

}
