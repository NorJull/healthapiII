package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;

public interface ServicioTipoProcedimiento {

	public Integer subirArchivoTiposProcedimientos(MultipartFile archivoTiposProcedimientos);

	public List<TipoProcedimiento> getProceduresType();

	public TipoProcedimiento getProceduresType(int id);

	public void updateProcedureType(TipoProcedimiento procedureType, int id);

	public List<TipoProcedimiento> getProceduresType(String codigoConcepto, String genero);

	public List<TipoProcedimiento> getProceduresType(String codigoConcepto);
	
	
}
