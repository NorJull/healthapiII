package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.ProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureRate;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface ProcedureRateDAO {

	public void addProcedureRate(ProcedureRate procedureRate, Session session) throws ProcedureTypeDoesNotExist, DuplicateProcedureRate;

	public List<ProcedureRate> getProcedureRates();

	public boolean procedureRateExist(int manualId, String cup, Session session);

	public List<ProcedureRate> getProcedureRatesByManual(int manualId);


}
