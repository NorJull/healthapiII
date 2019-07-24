package com.vamosaprogramar.umedicalapi.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedimientoOrdenado;

public interface ServicioProcedimientoOrdenado {
	
	public List<ProcedimientoOrdenado> obtenerProcedimientosOrdenados(String documento, String tipoDocumento);

	public void subirResultados(MultipartFile resultados, int procedimientoOrdenadoId);
	
	public File descargarResultados(int procedimientoOrdenadoId);
}
