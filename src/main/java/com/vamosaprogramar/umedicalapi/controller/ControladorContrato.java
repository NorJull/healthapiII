package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.service.ServicioContrato;

@RestController
@RequestMapping("contratos")
public class ControladorContrato {

	@Autowired
	private ServicioContrato servicioContrato;

	@GetMapping()
	public List<Contrato> obtenerContratos() {

		return servicioContrato.obtenerContratos();
	}

	@GetMapping("{id}")
	public Contrato obtenerContrato(@PathVariable int id) {

		Contrato c = servicioContrato.obtenerContrato(id);
		return c;
	}

	@GetMapping("/{id}/tiposProcedimientos")
	public List<TipoProcedimiento> obtenerTiposProcedimientos(@PathVariable int id) {

		return servicioContrato.obtenerTiposProcedimientos(id);
	}

	@GetMapping("/{id}/patients")
	public List<Patient> obtenerPacientes(@PathVariable int id) {

		return servicioContrato.getPatients(id);
	}

	@PostMapping()
	public Integer crearContrato(@RequestBody Contrato contract) {

		return servicioContrato.crearContrato(contract);
	}

	@PostMapping(path = "/{id}/tiposProcedimientos/subirArchivo", consumes = { "multipart/form-data" })
	public Integer subirArchivoTiposProcedimientos(@RequestParam("file") MultipartFile archivoTiposProcedimientos,
			@PathVariable int id) {

		if (archivoTiposProcedimientos.isEmpty()) {
			return null;
		}

		return servicioContrato.subirArchivoTiposProcedimientos(archivoTiposProcedimientos, id);
		
	}

	@PostMapping(path = "/{id}/patients/uploadFile", consumes = { "multipart/form-data" })
	public Integer uploadPatientsFile(@RequestParam("file") MultipartFile PatientsFile, @PathVariable int id) {

		// contract procedures
		if (PatientsFile.isEmpty()) {

			return null;
		}

		Integer processId = servicioContrato.uploadPatientsFile(PatientsFile, id);

		return processId;
	}

	@PutMapping()
	public void updateContract(@RequestBody Contrato contract) {
		servicioContrato.actualizarContrato(contract);
	}

}
