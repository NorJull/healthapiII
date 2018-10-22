package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface SpecialityServiceAsync {

	
	public void addProcedureTypes(BufferedReader bufferedReader,int specialityId, int processId, int totalRows);

	
}
