package com.vamosaprogramar.umedicalapi.dao;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;

public interface ManualTarifarioDAO {
	
	public List<ManualTarifario> obtenerManualesTarifarios();
	
	public ManualTarifario obtenerManualTarifario(int id);
	
	public Integer	crearManualTarifario(ManualTarifario rateManual);

	public void eliminarManualTarifario(int id);

	public boolean exiteManualTarifario(int id);
}
