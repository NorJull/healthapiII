package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.RegistroAIEPIDAO;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;

@Service
public class ServicioRegistroAIEPIImpl implements ServicioRegistroAIEPI {

	@Autowired
	private RegistroAIEPIDAO registroAIEPIDAO;
	
	@Override
	public List<RegistroAIEPIResult> obtenerRegistroSAIEPIsPorPaciente(int patientId) {
		return registroAIEPIDAO.obtenerResgitrosAIEPIsPorPaciente(patientId);
	}

	@Override
	public void crearRegistroAIEPI(RegistroAIEPI aiepi) {
		registroAIEPIDAO.crearRegistroAIEPI(aiepi);
	}

	@Override
	public RegistroAIEPI getRegistroAIEPI(int id) {
		return registroAIEPIDAO.getRegistroAIEPI(id);
	}

}
