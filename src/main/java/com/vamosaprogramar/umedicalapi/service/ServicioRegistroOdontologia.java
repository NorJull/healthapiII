package com.vamosaprogramar.umedicalapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;

import java.util.List;

public interface ServicioRegistroOdontologia {

    List<RegistroOdontologiaResult> obtenerRegistroOdontologiaResultPorPaciente(int pacienteId);

    void crearRegistroHistoriaClinica(RegistroOdontologia registroOdontologia);

    RegistroOdontologia obtenerRegistroOdontologia(int id);

	String obtenerOdontograma(int pacienteId);

	void cambiarOdontograma(JsonNode odontograma, int pacienteId);
}
