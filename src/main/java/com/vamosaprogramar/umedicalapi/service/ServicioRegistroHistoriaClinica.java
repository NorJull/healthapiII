package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;

public interface ServicioRegistroHistoriaClinica {

	List<RegistroHistoriaClinicaResult> obtenerRegistroHistoriaClinicasPorPaciente(int pacienteId);

	void crearRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica);

	RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int id);

}
