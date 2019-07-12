package com.vamosaprogramar.umedicalapi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.AppointmentDAO;
import com.vamosaprogramar.umedicalapi.dao.MedicamentoOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOrdenadoOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.dao.RegistroOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.dao.RemisionOdontologiaDAO;
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
    
    @Autowired
    private MedicamentoOdontologiaDAO medicamentoOdontologiaDAO;

    @Autowired
    private ProcedimientoOdontologiaDAO procedimientoOdontologiaDAO;

    @Autowired
    private ProcedimientoOrdenadoOdontologiaDAO procedimientoOrdenadoOdontologiaDAO;
    
    @Autowired
    private RemisionOdontologiaDAO remisionOdontologiaDAO;
    
    @Autowired
    private PatientDAO patientDAO;
    
    @Autowired
    private AppointmentDAO appointmentDAO;
    
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
        
        //Poner en null las listas originales
        registroOdontologia.setProcedimientoOdontologias(null);
        registroOdontologia.setProcedimientoOrdenadoOdontologias(null);
        registroOdontologia.setMedicamentoOdontologias(null);
        registroOdontologia.setRemisionOdontologias(null);
        
        //Guardar registro Odontologia
        Integer registroOdontologiaId = registroOdontologiaDAO.crearRegistroOdontologia(registroOdontologia);
        
		//Guardar procedimientos, procedimintos ordenados, remisiones y medicamentos
        

		for (ProcedimientoOdontologia procedimientoOdontologia : procedimientoOdontologias) {
			procedimientoOdontologiaDAO.crearProcedimientoOdontologia(procedimientoOdontologia, registroOdontologiaId);
		}
		
		for (ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia : procedimientosOrdenadoOdontologias) {
			procedimientoOrdenadoOdontologiaDAO.crearProcedimientoOrdenadoOdontologia(procedimientoOrdenadoOdontologia, registroOdontologiaId);
		}
		
		for (RemisionOdontologia remisionOdontologia : remisionOdontologias) {
			remisionOdontologiaDAO.crearRemisionOdontologia(remisionOdontologia, registroOdontologiaId);
		}
		
		for (MedicamentoOdontologia medicamentoOdontologia : medicamentoOdontologias) {
			medicamentoOdontologiaDAO.crearMedicamentoOdontologia(medicamentoOdontologia, registroOdontologiaId);
		}
		
		//Finalizar cita 
		appointmentDAO.cambiarEstado(registroOdontologia.getAppointmentId(), GeneralConstants.APPOINTMENT_STATE_FINISHED);
       
    }

    @Override
    public RegistroOdontologia obtenerRegistroOdontologia(int id) {
        return registroOdontologiaDAO.obtenerRegistroOdontologia(id);
    }

	@Override
	public String obtenerOdontograma(int pacienteId) {
		return patientDAO.obtenerOdontograma(pacienteId);
	}

	@Override
	public void cambiarOdontograma(JsonNode odontograma, int pacienteId) {
		 patientDAO.cambiarOdontograma(odontograma.toString(), pacienteId);		
	}
}
