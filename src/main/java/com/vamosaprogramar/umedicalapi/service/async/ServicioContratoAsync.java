package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface ServicioContratoAsync {
	
	public void asociarTiposProcedimientos(BufferedReader bufferedReader,int contractId, int processId, int totalRows);

	public void addPatients(BufferedReader bufferedReader, int contractId, Integer processId, int totalRows);
}
