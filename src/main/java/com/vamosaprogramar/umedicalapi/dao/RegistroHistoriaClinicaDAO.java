package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;

public interface RegistroHistoriaClinicaDAO {

	List<RegistroHistoriaClinicaResult> obtenerRegistroHistoriaClinicasPorPaciente(int patientId);

	Integer crearRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica);

	RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int id);

}
