package com.vamosaprogramar.umedicalapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.MedicamentoAIEPIDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimentoAIEPIDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOrdenadoAIEPIDAO;
import com.vamosaprogramar.umedicalapi.dao.RegistroAIEPIDAO;
import com.vamosaprogramar.umedicalapi.dao.RemisionAIEPIDAO;
import com.vamosaprogramar.umedicalapi.entity.MedicamentoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RemisionAIEPI;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroAIEPIResult;

@Service
public class ServicioRegistroAIEPIImpl implements ServicioRegistroAIEPI {

	@Autowired
	private RegistroAIEPIDAO registroAIEPIDAO;
	@Autowired
	private ProcedimentoAIEPIDAO procedimentoAIEPIDAO;
	@Autowired
	private MedicamentoAIEPIDAO medicamentoAIEPIDAO;
	@Autowired
	private ProcedimientoOrdenadoAIEPIDAO procedimientoOrdenadoAIEPIDAO;	
	@Autowired
	private RemisionAIEPIDAO remisionAIEPIDAO;
	
	
	@Override
	public List<RegistroAIEPIResult> obtenerRegistroSAIEPIsPorPaciente(int patientId) {
		return registroAIEPIDAO.obtenerResgitrosAIEPIsPorPaciente(patientId);
	}

	@Override
	public void crearRegistroAIEPI(RegistroAIEPI registroAIEPI) {
		List<ProcedimientoAIEPI> procedimientoAIEPIs = new ArrayList<>();
		List<ProcedimientoOrdenadoAIEPI> procedimientoOrdenadoAIEPIs =  new ArrayList<>();
		List<RemisionAIEPI> remisionAIEPIs = new ArrayList<>();
		List<MedicamentoAIEPI> medicamentoAIEPIs = new ArrayList<>();
		
		//Clonar las listas
		if(registroAIEPI.getProcedimientosAIEPIs() != null)
			procedimientoAIEPIs = new ArrayList<ProcedimientoAIEPI>(registroAIEPI.getProcedimientosAIEPIs());
		
		if(registroAIEPI.getProcedimientosOrdenadoAIEPIs() != null)
			procedimientoOrdenadoAIEPIs = new ArrayList<ProcedimientoOrdenadoAIEPI>(registroAIEPI.getProcedimientosOrdenadoAIEPIs());
	
		if(registroAIEPI.getRemisionAIEPIs() != null)
			remisionAIEPIs = new ArrayList<RemisionAIEPI>(registroAIEPI.getRemisionAIEPIs());
	
		if(registroAIEPI.getMedicamentosAIEPIs() != null)
			medicamentoAIEPIs = new ArrayList<MedicamentoAIEPI>(registroAIEPI.getMedicamentosAIEPIs());
	
		//Poner en null las listas originales
		registroAIEPI.setProcedimientosAIEPIs(null);
		registroAIEPI.setProcedimientosOrdenadoAIEPIs(null);
		registroAIEPI.setMedicamentosAIEPIs(null);
		registroAIEPI.setRemisionAIEPIs(null);
	
		//Guardar registro de AIEPI
		Integer registroAIEPIId = registroAIEPIDAO.crearRegistroAIEPI(registroAIEPI);;
	
		//Guardar procedimientos, procedimintos ordenados, remisiones y medicamentos

		for (ProcedimientoAIEPI procedimientoAIEPI : procedimientoAIEPIs) {
			procedimentoAIEPIDAO.crearProcedimientoAIEPI(procedimientoAIEPI, registroAIEPIId);
		}
		
		for (ProcedimientoOrdenadoAIEPI procedimientoOrdenadoAIEPI : procedimientoOrdenadoAIEPIs) {
			procedimientoOrdenadoAIEPIDAO.crearProcedimientoOrdenadoAIEPI(procedimientoOrdenadoAIEPI, registroAIEPIId);
		}
		
		for (RemisionAIEPI remisionAIEPI : remisionAIEPIs) {
			remisionAIEPIDAO.crearRemisionAIEPI(remisionAIEPI, registroAIEPIId);
		}
		
		for (MedicamentoAIEPI medicamentoAIEPI : medicamentoAIEPIs) {
			medicamentoAIEPIDAO.crearMedicamantoAIEPI(medicamentoAIEPI, registroAIEPIId);
		}
	}

	

	@Override
	public RegistroAIEPI getRegistroAIEPI(int id) {
		return registroAIEPIDAO.getRegistroAIEPI(id);
	}

}
