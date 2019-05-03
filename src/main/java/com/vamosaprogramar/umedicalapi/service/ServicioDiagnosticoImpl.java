package com.vamosaprogramar.umedicalapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.DiagnosticoDAO;
import com.vamosaprogramar.umedicalapi.entity.Diagnostico;

@Service
public class ServicioDiagnosticoImpl implements ServicioDiagnostico {

	@Autowired
	private DiagnosticoDAO diagnosticoDAO;
	
	@Override
	public Diagnostico obtenerDiagnosticoPorCodigo(String codigo) {
		return diagnosticoDAO.obtenerDiagnosticoPorCodigo(codigo);
	}

}
