package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.RegistroHistoriaClinicaDAO;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.result.RegistroHistoriaClinicaResult;

@Service
public class ServicioRegistroHistoriaClinicaImpl implements ServicioRegistroHistoriaClinica {

	@Autowired
	private RegistroHistoriaClinicaDAO medicalRecordDAO;
	
	@Override
	public List<RegistroHistoriaClinicaResult> obtenerRegistroHistoriaClinicasPorPaciente(int pacienteId) {
		return medicalRecordDAO.obtenerRegistroHistoriaClinicasPorPaciente(pacienteId);
	}

	@Override
	public void crearRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		medicalRecordDAO.crearRegistroHistoriaClinica(registroHistoriaClinica);	
	}

	@Override
	public RegistroHistoriaClinica obtenerRegistroHistoriaClinica(int id) {
	
		return medicalRecordDAO.obtenerRegistroHistoriaClinica(id);
	}

}
