package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.ProcedureRate;

public interface ProcedureRateService {

	public void addProcedureRate(ProcedureRate procedureRate);

	public List<ProcedureRate> getProcedureRates();
	
	
	public void addProdedureRates(BufferedReader bufferedReader, int manualId, int processId, int totalRows  );

	public List<ProcedureRate> getProcedureRatesByManual(int manualId); 


}
