package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.PatientDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimentoAIEPIDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOdontologiaDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedimientoOrdenadoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcedureRateDAO;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Procedimiento;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoAIEPI;
import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenadoOdontologia;
import com.vamosaprogramar.umedicalapi.entity.RegistroAIEPI;
import com.vamosaprogramar.umedicalapi.entity.RegistroHistoriaClinica;
import com.vamosaprogramar.umedicalapi.entity.RegistroOdontologia;

@Service
public class ServicioProcedimientosOrdenadosImpl implements ServicioProcedimientoOrdenado {

	@Autowired
	private PatientDAO patientDAO;
	@Autowired
	private ProcedimientoOrdenadoDAO procedimientoOrdenadoDAO;
	@Autowired
	private ProcedureRateDAO procedureRateDAO;
	@Autowired
	private ProcedimientoDAO procedimientoDAO;
	@Autowired
	private ProcedimentoAIEPIDAO procedimentoAIEPIDAO;
    @Autowired
    private ProcedimientoOdontologiaDAO procedimientoOdontologiaDAO;
	
    @Override
	public List<ProcedimientoOrdenado> obtenerProcedimientosOrdenados(String documento, String tipoDocumento) {		
		Patient patient = patientDAO.getPatientByDocumentAndDocumentType(documento, tipoDocumento);
		if(patient == null )
			return new ArrayList<ProcedimientoOrdenado>();
		
		List<ProcedimientoOrdenado> procedimientoOrdenados = procedimientoOrdenadoDAO.obtenerProcedimientosOrdenados(patient.getId());
		return procedimientoOrdenados;
	}

	@Override
	public void subirResultados(MultipartFile resultados, int procedimientoOrdenadoId, String tipoHistoria) {

		String pathString = GeneralConstants.BACTE_UPLOAD_FOLDER +"result"+UUID.randomUUID().toString()+".pdf";
		
		try {
			if(tipoHistoria.equals(GeneralConstants.HISTORIA_CLINICA_NORMAL)) {
				ProcedimientoOrdenado procedimientoOrdenado = procedimientoOrdenadoDAO.obtenerProcedimientoOrdenado(procedimientoOrdenadoId);
				
				Procedimiento procedimiento = new Procedimiento(procedimientoOrdenado);				
				
				RegistroHistoriaClinica registroHistoriaClinica = procedimientoOrdenadoDAO.obtenerRegistroHistoriaClinica(procedimientoOrdenadoId);
				
			//	Double valor = procedureRateDAO.obtenerValorProcedimeinto(registroHistoriaClinica.getContratoId(), procedimiento.getCup());
				
			//	procedimiento.setValor(valor);
				
				procedimientoDAO.crearProcedimiento(procedimiento, registroHistoriaClinica.getId());
				
				procedimientoOrdenadoDAO.cambiarEstadoURLProcedimientoOrdenado(procedimientoOrdenadoId, GeneralConstants.EJECUTADO, pathString);
				
			}else if(tipoHistoria.equals(GeneralConstants.HISTORIA_CLINICA_ODONTOLOGIA)) {
					ProcedimientoOrdenadoOdontologia procedimientoOrdenadoOdontologia = procedimientoOrdenadoDAO.obtenerProcedimientoOrdenadoOdontologia(procedimientoOrdenadoId);
					
					ProcedimientoOdontologia procedimientoOdontologia = new ProcedimientoOdontologia(procedimientoOrdenadoOdontologia);
					
					RegistroOdontologia registroOdontologia = procedimientoOrdenadoDAO.obtenerRegistroOdontologia(procedimientoOrdenadoId);
					
					Double valor = procedureRateDAO.obtenerValorProcedimeinto(registroOdontologia.getContratoId(), procedimientoOdontologia.getCup());
					
					procedimientoOdontologia.setValor(valor);
					
					procedimientoOdontologiaDAO.crearProcedimientoOdontologia(procedimientoOdontologia, registroOdontologia.getId());
					
					procedimientoOrdenadoDAO.cambiarEstadoURLProcedimientoOrdenadoOdontologia(procedimientoOrdenadoId, GeneralConstants.EJECUTADO, pathString);

					
				}else if(tipoHistoria.equals(GeneralConstants.HISTORIA_CLINICA_AIEPI)) {
					ProcedimientoOrdenadoAIEPI procedimientoOrdenadoAIEPI = procedimientoOrdenadoDAO.obtenerProcedimientoOrdenadoAIEPI(procedimientoOrdenadoId);
					
					ProcedimientoAIEPI procedimientoAIEPI = new ProcedimientoAIEPI(procedimientoOrdenadoAIEPI);
					
					RegistroAIEPI registroAIEPI = procedimientoOrdenadoDAO.obtenerRegistroAIEPI(procedimientoOrdenadoId);
					
					Double valor = procedureRateDAO.obtenerValorProcedimeinto(registroAIEPI.getContratoId(), procedimientoAIEPI.getCup());
					
					procedimientoAIEPI.setValor(valor);
					
					procedimentoAIEPIDAO.crearProcedimientoAIEPI(procedimientoAIEPI, registroAIEPI.getId());
					
					procedimientoOrdenadoDAO.cambiarEstadoURLProcedimientoOrdenadoAIEPI(procedimientoOrdenadoId, GeneralConstants.EJECUTADO, pathString);

				}
			
			byte[] bytes = resultados.getBytes();
			Path path = Paths.get(pathString);
			
			Files.write(path,bytes);
			
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
