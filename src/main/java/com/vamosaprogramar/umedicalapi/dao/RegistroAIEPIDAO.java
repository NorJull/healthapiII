package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;

public interface RegistroAIEPIDAO {

	List<RegistroAIEPIResult> obtenerResgitrosAIEPIsPorPaciente(int patientId);

	void crearRegistroAIEPI(RegistroAIEPI registroAIEPI);

	RegistroAIEPI getRegistroAIEPI(int id);

}
