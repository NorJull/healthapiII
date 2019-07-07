package com.vamosaprogramar.umedicalapi.entity.result;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class APResultado {
	
	private String factura; 

	private String prestador;
	
	private String tipoDocumentoPaciente;
	
	private String documentoPaciente;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private Date fechaProcedimiento;
	
	private String numeroAutorizacion;
	
	private String codigoProcedimiento;
	
	private String ambitoRealizacionProcedimiento;
	
	private String finalidadProcedimiento;
	
	private String personalAtiende;
	
	private String diagnosticoPrincipal;
	
	private String diagnosticoRelacionado;
	
	private String codigoDiagnosticoComplicacion;
	
	private String formaRealizacionActoQuirurjico;
	
	private double valorProcedimiento;

	public APResultado() {
	}

	
	public APResultado(String factura, String prestador, String tipoDocumentoPaciente, String documentoPaciente,
			Date fechaProcedimiento, String numeroAutorizacion, String codigoProcedimiento,
			String ambitoRealizacionProcedimiento, String finalidadProcedimiento, String personalAtiende,
			String diagnosticoPrincipal, String diagnosticoRelacionado, String codigoDiagnosticoComplicacion,
			String formaRealizacionActoQuirurjico, double valorProcedimiento) {
		super();
		this.factura = factura;
		this.prestador = prestador;
		this.tipoDocumentoPaciente = tipoDocumentoPaciente;
		this.documentoPaciente = documentoPaciente;
		this.fechaProcedimiento = fechaProcedimiento;
		this.numeroAutorizacion = numeroAutorizacion;
		this.codigoProcedimiento = codigoProcedimiento;
		this.ambitoRealizacionProcedimiento = ambitoRealizacionProcedimiento;
		this.finalidadProcedimiento = finalidadProcedimiento;
		this.personalAtiende = personalAtiende;
		this.diagnosticoPrincipal = diagnosticoPrincipal;
		this.diagnosticoRelacionado = diagnosticoRelacionado;
		this.codigoDiagnosticoComplicacion = codigoDiagnosticoComplicacion;
		this.formaRealizacionActoQuirurjico = formaRealizacionActoQuirurjico;
		this.valorProcedimiento = valorProcedimiento;
	}


	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getPrestador() {
		return prestador;
	}

	public void setPrestador(String prestador) {
		this.prestador = prestador;
	}

	public String getTipoDocumentoPaciente() {
		return tipoDocumentoPaciente;
	}

	public void setTipoDocumentoPaciente(String tipoDocumentoPaciente) {
		this.tipoDocumentoPaciente = tipoDocumentoPaciente;
	}

	public String getDocumentoPaciente() {
		return documentoPaciente;
	}

	public void setDocumentoPaciente(String documentoPaciente) {
		this.documentoPaciente = documentoPaciente;
	}

	public Date getFechaProcedimiento() {
		return fechaProcedimiento;
	}

	public void setFechaProcedimiento(Date fechaProcedimiento) {
		this.fechaProcedimiento = fechaProcedimiento;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getCodigoProcedimiento() {
		return codigoProcedimiento;
	}

	public void setCodigoProcedimiento(String codigoProcedimiento) {
		this.codigoProcedimiento = codigoProcedimiento;
	}

	public String getAmbitoRealizacionProcedimiento() {
		return ambitoRealizacionProcedimiento;
	}

	public void setAmbitoRealizacionProcedimiento(String ambitoRealizacionProcedimiento) {
		this.ambitoRealizacionProcedimiento = ambitoRealizacionProcedimiento;
	}

	public String getFinalidadProcedimiento() {
		return finalidadProcedimiento;
	}

	public void setFinalidadProcedimiento(String finalidadProcedimiento) {
		this.finalidadProcedimiento = finalidadProcedimiento;
	}

	public String getPersonalAtiende() {
		return personalAtiende;
	}

	public void setPersonalAtiende(String personalAtiende) {
		this.personalAtiende = personalAtiende;
	}

	public String getDiagnosticoPrincipal() {
		return diagnosticoPrincipal;
	}

	public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
		this.diagnosticoPrincipal = diagnosticoPrincipal;
	}

	public String getDiagnosticoRelacionado() {
		return diagnosticoRelacionado;
	}

	public void setDiagnosticoRelacionado(String diagnosticoRelacionado) {
		this.diagnosticoRelacionado = diagnosticoRelacionado;
	}

	public String getCodigoDiagnosticoComplicacion() {
		return codigoDiagnosticoComplicacion;
	}

	public void setCodigoDiagnosticoComplicacion(String codigoDiagnosticoComplicacion) {
		this.codigoDiagnosticoComplicacion = codigoDiagnosticoComplicacion;
	}

	public String getFormaRealizacionActoQuirurjico() {
		return formaRealizacionActoQuirurjico;
	}

	public void setFormaRealizacionActoQuirurjico(String formaRealizacionActoQuirurjico) {
		this.formaRealizacionActoQuirurjico = formaRealizacionActoQuirurjico;
	}

	public double getValorProcedimiento() {
		return valorProcedimiento;
	}

	public void setValorProcedimiento(double valorProcedimiento) {
		this.valorProcedimiento = valorProcedimiento;
	}
	
	public String[] getStringArray() {
		String[] datos = {factura,prestador,tipoDocumentoPaciente, documentoPaciente, fechaProcedimiento.toString(),
				numeroAutorizacion,codigoProcedimiento,ambitoRealizacionProcedimiento,finalidadProcedimiento,personalAtiende,
				diagnosticoPrincipal,diagnosticoRelacionado,codigoDiagnosticoComplicacion,formaRealizacionActoQuirurjico,
				String.valueOf(valorProcedimiento)};
		return datos;
	}	
}
