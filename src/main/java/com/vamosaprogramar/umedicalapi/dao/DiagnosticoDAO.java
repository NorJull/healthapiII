package com.vamosaprogramar.umedicalapi.dao;

import com.vamosaprogramar.umedicalapi.entity.Diagnostico;

public interface DiagnosticoDAO {

	public Diagnostico obtenerDiagnosticoPorCodigo(String codigo);
}
