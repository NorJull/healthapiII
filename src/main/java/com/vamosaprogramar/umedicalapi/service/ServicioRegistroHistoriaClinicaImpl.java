package com.vamosaprogramar.umedicalapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.MedicamentoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOrdenadoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedureRateDAO;
import com.vamosaprogramar.umedicalapi.dao.RegistroHistoriaClinicaDAO;
import com.vamosaprogramar.umedicalapi.dao.RemisionDAO;
import com.vamosaprogramar.umedicalapi.entity.Medicamento;
import com.vamosaprogramar.umedicalapi.entity.Procedimiento;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.Remision;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;

@Service
public class ServicioRegistroHistoriaClinicaImpl implements ServicioRegistroHistoriaClinica {

	@Autowired
	private RegistroHistoriaClinicaDAO medicalRecordDAO;
	@Autowired
	private ProcedimientoDAO procedimientoDAO;
	@Autowired
	private MedicamentoDAO medicamentoDAO;
	@Autowired
	private ProcedimientoOrdenadoDAO procedimientoOrdenadoDAO;
	@Autowired
	private RemisionDAO remsionDAO;
	@Autowired
	private ProcedureRateDAO procedureRateDAO;
	
	@Override
	public List<RegistroHistoriaClinicaResult> obtenerRegistroHistoriaClinicasPorPaciente(int pacienteId) {
		return medicalRecordDAO.obtenerRegistroHistoriaClinicasPorPaciente(pacienteId);
	}

	@Override
	public void crearRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		
		List<Procedimiento> procedimientos = new ArrayList<>();
		List<ProcedimientoOrdenado> procedimientosOrdenados = new ArrayList<>();
		List<Remision> remisiones = new ArrayList<>();
		List<Medicamento> medicamentos = new ArrayList<>();
		
		//Clonar las listas
		
		if(registroHistoriaClinica.getProcedimientos() != null)
			procedimientos =new ArrayList<Procedimiento>(registroHistoriaClinica.getProcedimientos());
		
		if (registroHistoriaClinica.getProcedimientosOrdenados() != null)
		procedimientosOrdenados = new ArrayList<ProcedimientoOrdenado>(registroHistoriaClinica.getProcedimientosOrdenados());
		
		if(registroHistoriaClinica.getRemisiones() != null)
		remisiones = new ArrayList<Remision> (registroHistoriaClinica.getRemisiones());
		
		if(registroHistoriaClinica.getMedicamentos() != null)
		medicamentos = new ArrayList<Medicamento> (registroHistoriaClinica.getMedicamentos());
		
		
		//Poner en null las listas originales
		
		registroHistoriaClinica.setProcedimientos(null);
		registroHistoriaClinica.setProcedimientosOrdenados(null);
		registroHistoriaClinica.setRemisiones(null);
		registroHistoriaClinica.setMedicamentos(null);
		
		
		//Guardar Registro Historia Clinica
		Integer registroHistoriaClinicaId = medicalRecordDAO.crearRegistroHistoriaClinica(registroHistoriaClinica);	
		
		//Guardar procedimientos, procedimintos ordenados, remisiones y medicamentos

		for (Procedimiento procedimiento : procedimientos) {
				Double valor = procedureRateDAO.obtenerValorProcedimeinto(registroHistoriaClinica.getContratoId(), procedimiento.getCup());
				procedimiento.setValor(valor);
				procedimientoDAO.crearProcedimiento(procedimiento, registroHistoriaClinicaId);
		}
		
		for (ProcedimientoOrdenado procedimientosOrdenado : procedimientosOrdenados) {
			procedimientoOrdenadoDAO.crearProcedimientoOrdenado(procedimientosOrdenado, registroHistoriaClinicaId);
		}
		
		for (Remision remision : remisiones) {
			remsionDAO.crearRemision(remision, registroHistoriaClinicaId);
		}
		for (Medicamento medicamento : medicamentos) {
			medicamentoDAO.crearMedicamento(medicamento, registroHistoriaClinicaId);
		}
		
	}

	@Override
	public RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int id) {
		return medicalRecordDAO.obtenerRegistroHistoriaClinica(id);
	}

}
