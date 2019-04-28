package com.vamosaprogramar.umedicalapi.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.GeneralConstants;
import com.vamosaprogramar.umedicalapi.dao.ContratoDAO;
import com.vamosaprogramar.umedicalapi.dao.ProcessDAO;
import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.service.async.ServicioContratoAsync;

@Service
public class ContractServiceImpl implements ServicioContrato {

	@Autowired
	private ContratoDAO contratoDAO;
	
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private ServicioContratoAsync servicioContratoAsync;
	
	@Override
	public List<Contrato> obtenerContratos() {
		
		return contratoDAO.obtenerContratos();
	}

	@Override
	public Contrato obtenerContrato(int id) {
	
		return contratoDAO.obtenerContrato(id);
	}

	@Override
	public Integer crearContrato(Contrato contract) {

		return contratoDAO.crearContrato(contract);
	}

	@Override
	public Integer subirArchivoTiposProcedimientos(MultipartFile archivoTiposProcedimientos, int contratoId){
				
		try{
			byte[] bytes = archivoTiposProcedimientos.getBytes();	

			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + archivoTiposProcedimientos.getOriginalFilename() );
			
			Files.write(path, bytes);
			
			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + archivoTiposProcedimientos.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			
			
			Process process = new  Process(1, GeneralConstants.PROCEDIMIENTOS_DE_UN_CONTRATO, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			servicioContratoAsync.asociarTiposProcedimientos(bufferedReader,contratoId, processId, totalRows);
			
			return processId;
			
		}catch (Exception e) {
			e.printStackTrace();
		}	

		return null;
		
	}

	@Override
	public List<Contrato> obtenerContratosPorEntidad(int healthEntityId) {
		
		return contratoDAO.obtenerContratosPorEntidad(healthEntityId);
	}

	@Override
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int contractId) {
		
		return contratoDAO.obtenerTiposProcedimientos(contractId);
	}

	@Override
	public Integer uploadPatientsFile(MultipartFile patientsFile, int contractId) {
				
		try{
			byte[] bytes = patientsFile.getBytes();	

			Path path = Paths.get(GeneralConstants.UPLOAD_FOLDER + patientsFile.getOriginalFilename() );
			
			Files.write(path, bytes);
			
			FileReader fileReader = new FileReader(GeneralConstants.UPLOAD_FOLDER + patientsFile.getOriginalFilename());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			bufferedReader.mark(100000);
			String line = bufferedReader.readLine();
			int totalRows = 0;
			
			while(line!=null) {
				totalRows++;
				line = bufferedReader.readLine();
			}
			
			bufferedReader.reset();
			
			
			Process process = new  Process(1, GeneralConstants.PACIENTES_DE_UN_CONTRATO, GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			servicioContratoAsync.addPatients(bufferedReader,contractId, processId, totalRows);
			
			return processId;
			
		}catch (Exception e) {
			e.printStackTrace();
		}	

			

		return null;
	
	}

	@Override
	public List<Patient> getPatients(int id) {
		
		return contratoDAO.getPatients(id);
	}

	@Override
	public void actualizarContrato(Contrato contract) {
		contratoDAO.updateContract(contract);		
	}

}
