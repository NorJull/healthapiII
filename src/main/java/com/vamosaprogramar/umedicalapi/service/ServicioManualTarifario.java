package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;

public interface ServicioManualTarifario {
	
	public List<ManualTarifario> obtenerManualesTarifarios();
	
	public ManualTarifario obtenerManualTarifario(int id);
	
	public Integer	crearManualTarifario(ManualTarifario manualTarifario);

	public void eliminarManualTarifario(int id);

	public Integer subirArchivoManualTarifario(MultipartFile archivoManualTarifario, int id);

}
