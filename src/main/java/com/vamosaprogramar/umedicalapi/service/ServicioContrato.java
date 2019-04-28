package com.vamosaprogramar.umedicalapi.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.Contrato;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;

public interface ServicioContrato {

	public List<Contrato> obtenerContratos();

	public Contrato obtenerContrato(int id);

	public Integer crearContrato(Contrato contract);

	public Integer subirArchivoTiposProcedimientos(MultipartFile archivoTiposProcedimientos, int contratoId);

	public List<Contrato> obtenerContratosPorEntidad(int entidadSaludId);

	public List<TipoProcedimiento> obtenerTiposProcedimientos(int contratoId);

	public Integer uploadPatientsFile(MultipartFile patientsFile, int contractId);

	public List<Patient> getPatients(int id);

	public void actualizarContrato(Contrato contracto);
		

}
