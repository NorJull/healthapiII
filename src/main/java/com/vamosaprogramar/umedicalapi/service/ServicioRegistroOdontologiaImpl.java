package com.vamosaprogramar.umedicalapi.service;

import com.vamosaprogramar.umedicalapi.dao.RegistroOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.entity.*;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroOdontologiaResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioRegistroOdontologiaImpl implements ServicioRegistroOdontologia {

    @Autowired
    private RegistroOdontologiaDAO registroOdontologiaDAO;


    @Override
    public List<RegistroOdontologiaResult> obtenerRegistroOdontologiaResultPorPaciente(int pacienteId) {
        return registroOdontologiaDAO.obtenerRegistroOdontologiaResultPorPaciente(pacienteId);
    }

    @Override
    public void crearRegistroHistoriaClinica(RegistroOdontologia registroOdontologia) {
        List<ProcedimientoOdontologia> procedimientoOdontologias = new ArrayList<>();
        List<ProcedimientoOrdenadoOdontologia> procedimientosOrdenadoOdontologias = new ArrayList<>();
        List<RemisionOdontologia> remisionOdontologias = new ArrayList<>();
        List<MedicamentoOdontologia> medicamentoOdontologias = new ArrayList<>();

        //Clonar las listas

        if(registroOdontologia.getProcedimientoOdontologias() != null)
            procedimientoOdontologias =new ArrayList<ProcedimientoOdontologia>(registroOdontologia.getProcedimientoOdontologias());

        if (registroOdontologia.getProcedimientoOrdenadoOdontologias() != null)
            procedimientosOrdenadoOdontologias = new ArrayList<ProcedimientoOrdenadoOdontologia>(registroOdontologia.getProcedimientoOrdenadoOdontologias());

        if(registroOdontologia.getRemisionOdontologias() != null)
            remisionOdontologias = new ArrayList<RemisionOdontologia> (registroOdontologia.getRemisionOdontologias());

        if(registroOdontologia.getMedicamentoOdontologias() != null)
            medicamentoOdontologias = new ArrayList<MedicamentoOdontologia> (registroOdontologia.getMedicamentoOdontologias());
    }

    @Override
    public RegistroOdontologia obtenerRegistroOdontologia(int id) {
        return registroOdontologiaDAO.obtenerRegistroOdontologia(id);
    }
}
