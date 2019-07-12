package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.TarifaProcedimiento;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface ProcedureRateDAO {

	public void addProcedureRate(TarifaProcedimiento procedureRate, Session session) throws ProcedureTypeDoesNotExist, DuplicateProcedureRate;

	public List<TarifaProcedimiento> getProcedureRates();

	public boolean procedureRateExist(int manualId, String cup, Session session);

	public List<TarifaProcedimiento> getProcedureRatesByManual(int manualId);
	
	public Double obtenerValorProcedimeinto(Integer contratoId, String cup);

}
