package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface ProcedureTypeServiceAsync {
	
	public void addProcedureTypes(BufferedReader bufferedReader, int processId, int totalRows);

}
