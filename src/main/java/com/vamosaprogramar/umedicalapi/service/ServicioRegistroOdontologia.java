package com.vamosaprogramar.umedicalapi.service;

import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;

import java.util.List;

public interface ServicioRegistroOdontologia {

    List<RegistroOdontologiaResult> obtenerRegistroOdontologiaResultPorPaciente(int pacienteId);

    void crearRegistroHistoriaClinica(RegistroOdontologia registroOdontologia);

    RegistroOdontologia obtenerRegistroOdontologia(int id);

	String obtenerOdontograma(int pacienteId);
}
