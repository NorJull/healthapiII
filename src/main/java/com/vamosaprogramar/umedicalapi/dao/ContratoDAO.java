package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.exception.PatientDoesNotExist;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface ContratoDAO {

	public List<Contrato> obtenerContratos();

	public Contrato obtenerContrato(int id);

	public Integer crearContrato(Contrato contract);

	public List<Contrato> obtenerContratosPorEntidad(int entidadSaludId);

	public boolean existeContrato(int contratoId);

	public void asociarTipoProcedimiento(int contratoId, String line, Session session) throws ProcedureTypeDoesNotExist;
	
		
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int contractId);

	public int addPatient(int contractId, String document, String documentType, Session session) throws PatientDoesNotExist;

	public List<Patient> getPatients(int id);

	public  void desasociarTiposProcedimientos(int contractId);

	public void updateContract(Contrato contract);
	
	
	

}
