package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.exception.DuplicateProcedureType;

public interface ProcedureTypeDAO {

	public void addProcedureType(ProcedureType procedureType);

	public List<ProcedureType> getProceduresType();

	public ProcedureType getProceduresType(int id);

	public void updateProcedureType(ProcedureType procedureType, int id);

	public void addProcedureType(ProcedureType procedureType, Session session) throws DuplicateProcedureType;
	
}
