package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;

import java.util.List;

public interface RegistroOdontologiaDAO {

    List<RegistroOdontologiaResult> obtenerRegistroOdontologiaResultPorPaciente(int patientId);

    Integer crearRegistroOdontologia(RegistroOdontologia registroOdontologia);

    RegistroOdontologia obtenerRegistroOdontologia(int id);

}
