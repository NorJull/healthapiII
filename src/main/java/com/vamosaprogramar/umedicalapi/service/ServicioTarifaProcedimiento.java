package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.TarifaProcedimiento;

public interface ServicioTarifaProcedimiento {

	public void crearTarifaProcedimiento(TarifaProcedimiento tarifaProcedimiento);

	public List<TarifaProcedimiento> obtenerTarifasProcedimientos();
	
	
	public void crearTarifaProcedimientos(BufferedReader bufferedReader, int manualId, int processId, int totalRows  );

	public List<TarifaProcedimiento> obtenerTarifasProcedimientosPorManual(int manualId); 


}
