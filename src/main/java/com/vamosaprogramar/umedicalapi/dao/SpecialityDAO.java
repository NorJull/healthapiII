package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import org.hibernate.Session;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.exception.ProcedureTypeDoesNotExist;

public interface SpecialityDAO {
	
public List<Speciality> getSpecialities();
	
	public Speciality getSpeciality(int id);
	
	public Integer addSpeciality(Speciality speciality);
	
	public List<ProcedureType> getProcedureTypes(int specialityId);

	public boolean specialityExist(int specialityId);

	public void addProcedureType(int specialityId, String cup, Session session) throws ProcedureTypeDoesNotExist;
	
}
