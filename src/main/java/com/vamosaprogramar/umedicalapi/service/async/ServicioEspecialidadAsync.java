package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface ServicioEspecialidadAsync {
	
	public void asociarTiposProcedimientos(BufferedReader bufferedReader,int specialityId, int processId, int totalRows);

	
}
