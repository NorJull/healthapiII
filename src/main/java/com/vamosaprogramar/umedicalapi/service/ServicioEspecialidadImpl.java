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
import com.vamosaprogramar.umedicalapi.dao.EspecialidadDAO;
import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.Process;
import com.vamosaprogramar.umedicalapi.entity.Especialidad;
import com.vamosaprogramar.umedicalapi.service.async.ServicioEspecialidadAsync;

@Service
public class ServicioEspecialidadImpl implements ServicioEspecialidad {

	@Autowired 
	private EspecialidadDAO especialidadDAO;
	
	@Autowired
	private ProcessDAO processDAO;
	
	@Autowired
	private ServicioEspecialidadAsync servicioEspecialidadAsync;
	
	@Override
	public List<Especialidad> obtenerEspecialidades() {
		return especialidadDAO.obtenerEspecialidades();
	}
	
	@Override
	public Especialidad obtenerEspecialidad(int id) {
		return especialidadDAO.obtenerEspecialidad(id);
	}


	@Override
	public Integer crearEspecialidad(Especialidad speciality) {
		return especialidadDAO.crearEspecialidad(speciality);
	}

	@Override
	public List<TipoProcedimiento> obtenerTiposProcedimientos(int specialityId) {
		return especialidadDAO.obtenerTiposProcedimientos(specialityId);
	}

	@Override
	public Integer subirArchivoTiposProcedimientos(MultipartFile archivoTiposProcedimientos, int especialidadId) {
		try {
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
			
			Process process = new  Process(1, GeneralConstants.PROCEDIMIENTOS_DE_UNA_ESPECIALIDAD,  GeneralConstants.EJECUCION, LocalDateTime.now(), null, totalRows,0, 0, null);
			
			Integer processId = processDAO.addProcess(process);
			
			servicioEspecialidadAsync.asociarTiposProcedimientos(bufferedReader, especialidadId, processId, totalRows);
			
			return processId;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<ApplicationUser> obtenerUsuarios(int id) {
		return especialidadDAO.obtenerUsuarios(id);
	}

	



	

}
