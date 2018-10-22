package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;
import com.vamosaprogramar.umedicalapi.entity.Speciality;

public interface SpecialityService {

	public List<Speciality> getSpecialities();
	
	public Speciality getSpeciality(int id);
	
	public Integer addSpeciality(Speciality speciality);
	
	public List<ProcedureType> getProcedureTypes(int specialityId);
	
	public Integer uploadProcedureTypesFile(MultipartFile procedureTypesFile, int specialityId);
	
	
}
