package com.vamosaprogramar.umedicalapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedureType;

public interface ProcedureTypeService {

	public Integer uploadProcedureTypeFile(MultipartFile procedureTypeFile);

	public List<ProcedureType> getProceduresType();

	public ProcedureType getProceduresType(int id);

	public void updateProcedureType(ProcedureType procedureType, int id);
	
	
}
