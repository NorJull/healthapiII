package com.vamosaprogramar.umedicalapi.service.async;

import java.io.BufferedReader;

public interface PatientServiceAsync {

	public void addPatients(BufferedReader bufferedReader, int processId, int totalRows);

}
