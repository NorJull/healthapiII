package com.vamosaprogramar.umedicalapi.service;

import com.vamosaprogramar.umedicalapi.entity.Diagnostico;

public interface ServicioDiagnostico {

	public Diagnostico obtenerDiagnosticoPorCodigo(String codigo);
}
