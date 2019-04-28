package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.dao.ManualTarifarioDAO;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;

@Service
public class ServicioManualTarifarioImpl implements ServicioManualTarifario {

	
	@Autowired
	private ManualTarifarioDAO manualTarifarioDAO;
	
	@Autowired
	private ServicioTarifaProcedimiento servicioTarifaProcedimiento;
	
	@Autowired
	private ProcessDAO processDAO;
	
	
	@Override
	public List<ManualTarifario> obtenerManualesTarifarios() {
		
		return manualTarifarioDAO.obtenerManualesTarifarios();
	}

	@Override
	public ManualTarifario obtenerManualTarifario(int id) {
	
		return manualTarifarioDAO.obtenerManualTarifario(id);
	}
	
	@Override
	public Integer crearManualTarifario(ManualTarifario rateManual) {
		
		return manualTarifarioDAO.crearManualTarifario(rateManual);
	}

	@Override
	public void eliminarManualTarifario(int id) {
		manualTarifarioDAO.eliminarManualTarifario(id);
		
	}

	@Override
	public Integer subirArchivoManualTarifario(MultipartFile archivoManualTarifario, int id) {
		
		try {
			byte[] bytes = archivoManualTarifario.getBytes();
			
			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + archivoManualTarifario.getOriginalFilename());
			
			Files.write(path,bytes);
			
			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + archivoManualTarifario.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			bufferedReader.reset();
			Process process = new Process(1, GeneralConstants.SUBIDA_DE_MUNUAL_TARIFARIO, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			servicioTarifaProcedimiento.crearTarifaProcedimientos(bufferedReader, id, processId, totalRows);
			
			return processId;
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	

}
