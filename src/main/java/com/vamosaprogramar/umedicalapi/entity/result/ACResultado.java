package com.vamosaprogramar.umedicalapi.entity.result;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ACResultado {
	
	private String numeroFactura;
	
	private String codigoPrestador;
	
	private String tipoIdentificacionPaciente;
	
	private String documento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fechaConsulta;
	
	private String numeroAutorizacion;
	
	private String codigoConsulta;
	
	private String finalidad;
	
	private String causaExterna;
	
	private String codigoDiagnosticoPrincipal;
	
	private String codigoDiagnosticoRelacionado1;

	private String codigoDiagnosticoRelacionado2;

	private String codigoDiagnosticoRelacionado3;
	
	private String tipoDiagnosticoPrincipal;
	
	private double valorConsulta;
	
	private double valorCuotaModeradora;
	
	private double valorNetoPagar;

	
	public ACResultado() {
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getCodigoPrestador() {
		return codigoPrestador;
	}

	public void setCodigoPrestador(String codigoPrestador) {
		this.codigoPrestador = codigoPrestador;
	}

	public String getTipoIdentificacionPaciente() {
		return tipoIdentificacionPaciente;
	}

	public void setTipoIdentificacionPaciente(String tipoIdentificacionPaciente) {
		this.tipoIdentificacionPaciente = tipoIdentificacionPaciente;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public LocalDate getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDate fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getCodigoConsulta() {
		return codigoConsulta;
	}

	public void setCodigoConsulta(String codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public String getCausaExterna() {
		return causaExterna;
	}

	public void setCausaExterna(String causaExterna) {
		this.causaExterna = causaExterna;
	}

	public String getCodigoDiagnosticoPrincipal() {
		return codigoDiagnosticoPrincipal;
	}

	public void setCodigoDiagnosticoPrincipal(String codigoDiagnosticoPrincipal) {
		this.codigoDiagnosticoPrincipal = codigoDiagnosticoPrincipal;
	}

	public String getCodigoDiagnosticoRelacionado1() {
		return codigoDiagnosticoRelacionado1;
	}

	public void setCodigoDiagnosticoRelacionado1(String codigoDiagnosticoRelacionado1) {
		this.codigoDiagnosticoRelacionado1 = codigoDiagnosticoRelacionado1;
	}

	public String getCodigoDiagnosticoRelacionado2() {
		return codigoDiagnosticoRelacionado2;
	}

	public void setCodigoDiagnosticoRelacionado2(String codigoDiagnosticoRelacionado2) {
		this.codigoDiagnosticoRelacionado2 = codigoDiagnosticoRelacionado2;
	}

	public String getCodigoDiagnosticoRelacionado3() {
		return codigoDiagnosticoRelacionado3;
	}

	public void setCodigoDiagnosticoRelacionado3(String codigoDiagnosticoRelacionado3) {
		this.codigoDiagnosticoRelacionado3 = codigoDiagnosticoRelacionado3;
	}

	public String getTipoDiagnosticoPrincipal() {
		return tipoDiagnosticoPrincipal;
	}

	public void setTipoDiagnosticoPrincipal(String tipoDiagnosticoPrincipal) {
		this.tipoDiagnosticoPrincipal = tipoDiagnosticoPrincipal;
	}

	public double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public double getValorCuotaModeradora() {
		return valorCuotaModeradora;
	}

	public void setValorCuotaModeradora(double valorCuotaModeradora) {
		this.valorCuotaModeradora = valorCuotaModeradora;
	}

	public double getValorNetoPagar() {
		return valorNetoPagar;
	}

	public void setValorNetoPagar(double valorNetoPagar) {
		this.valorNetoPagar = valorNetoPagar;
	}
	
	public String[] getStringArray() {
		String[] datos = {numeroFactura, codigoPrestador, tipoIdentificacionPaciente, documento, fechaConsulta.toString(),
				numeroAutorizacion, codigoConsulta, finalidad, causaExterna, codigoDiagnosticoPrincipal, codigoDiagnosticoRelacionado1, 
				codigoDiagnosticoRelacionado2, codigoDiagnosticoRelacionado3, tipoDiagnosticoPrincipal, String.valueOf(valorConsulta),
				String.valueOf(valorCuotaModeradora), String.valueOf(valorNetoPagar)};
		return datos;
	}
	
}
