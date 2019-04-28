package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vamosaprogramar.umedicalapi.entity.TarifaProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.ProcedureRateId;
import com.vamosaprogramar.umedicalapi.entity.TipoProcedimiento;
import com.vamosaprogramar.umedicalapi.entity.ManualTarifario;
import com.vamosaprogramar.umedicalapi.service.ServicioTarifaProcedimiento;
import com.vamosaprogramar.umedicalapi.service.ServicioTarifaProcedimientoImpl;
import com.vamosaprogramar.umedicalapi.service.ServicioManualTarifario;

@RestController
@RequestMapping("manualesTarifarios")
public class ControladorManualTarifario {
	
	@Autowired
	private ServicioManualTarifario servicioManualTarifario;
	
	@Autowired
	private ServicioTarifaProcedimiento servicioTarifaProcedimiento;
	
	@GetMapping()
	public List<ManualTarifario> getRateManuals(){
		return servicioManualTarifario.obtenerManualesTarifarios();
	}
	
	
	@GetMapping("{id}")
	public ManualTarifario getRateManual(@PathVariable int id) {
		return servicioManualTarifario.obtenerManualTarifario(id);
	}
	
	@GetMapping("{manualId}/tarifasProcedimientos")
	public List<TarifaProcedimiento> getProcedureRatesByManual(@PathVariable int manualId){
		List<TarifaProcedimiento> p = servicioTarifaProcedimiento.obtenerTarifasProcedimientosPorManual(manualId);
		System.out.println(p);
		return p;
	}
	
	@PostMapping()
	public Integer addRateManual(@RequestBody ManualTarifario rateManual) {
		return servicioManualTarifario.crearManualTarifario(rateManual);
	}
	
	@PostMapping(path = "{id}/subirArchivo", consumes = { "multipart/form-data" })
	public Integer subirArchivoManualTarifario(@RequestParam("file") MultipartFile archivoManualTarifario,@PathVariable int id) {
		
		if(archivoManualTarifario.isEmpty()) {
		return null;
		}
		return servicioManualTarifario.subirArchivoManualTarifario(archivoManualTarifario, id);
		
	}
	
	@DeleteMapping("{id}")
	public void deleteRateManual(@PathVariable int id) {
		servicioManualTarifario.eliminarManualTarifario(id);
	}
	
}
