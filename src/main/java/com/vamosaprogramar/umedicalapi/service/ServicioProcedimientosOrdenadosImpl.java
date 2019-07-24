package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOrdenadoDAO;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;

@Service
public class ServicioProcedimientosOrdenadosImpl implements ServicioProcedimientoOrdenado {

	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private ProcedimientoOrdenadoDAO procedimientoOrdenadoDAO;
	
	@Override
	public List<ProcedimientoOrdenado> obtenerProcedimientosOrdenados(String documento, String tipoDocumento) {		
		Patient patient = patientDAO.getPatientByDocumentAndDocumentType(documento, tipoDocumento);
		if(patient == null )
			return new ArrayList<ProcedimientoOrdenado>();
		
		List<ProcedimientoOrdenado> procedimientoOrdenados = procedimientoOrdenadoDAO.obtenerProcedimientosOrdenados(patient.getId());
		return procedimientoOrdenados;
	}

	@Override
	public void subirResultados(MultipartFile resultados, int procedimientoOrdenadoId) {
		try {
			
		}  catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public File descargarResultados(int procedimientoOrdenadoId) {
		// TODO Auto-generated method stub
		return null;
	}


}
