package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface ServicioTipoProcedimientoAsync {
	
	public void agregarTiposProcedimientos(BufferedReader bufferedReader, int processId, int totalRows);

}
