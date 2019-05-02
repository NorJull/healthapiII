package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;

public interface ServicioRegistroAIEPI {

	List<RegistroAIEPIResult> obtenerRegistroSAIEPIsPorPaciente(int patientId);

	void crearRegistroAIEPI(RegistroAIEPI registroAIEPI);

	RegistroAIEPI getRegistroAIEPI(int id);

}
