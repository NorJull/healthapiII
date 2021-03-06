package com.vamosaprogramar.umedicalapi.entity;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "procedimiento_ordenado")
public class ProcedimientoOrdenado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name="fecha")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate fecha;
	
	@Column(name = "numero_autorizacion")
	private String numeroAutorizacion;
	
	@Column(name = "cup")
	private String cup;

	@Column(name = "ambito_realizacion")
	private String ambitoRealizacion;

	@Column(name = "finalidad")
	private String finalidad;

	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;
	
	@Column(name = "codigo_diagnostico_relacionado")
	private String codigoDiagnosticoRelacionado;

	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "registro_historia_clinica_id")
	private RegistroHistoriaClinica registroHistoriaClinica;
	
	public ProcedimientoOrdenado() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getAmbitoRealizacion() {
		return ambitoRealizacion;
	}

	public void setAmbitoRealizacion(String ambitoRealizacion) {
		this.ambitoRealizacion = ambitoRealizacion;
	}

	public String getFinalidad() {
		return finalidad;
	}

	public void setFinalidad(String finalidad) {
		this.finalidad = finalidad;
	}

	public String getCodigoDiagnosticoPrincipal() {
		return codigoDiagnosticoPrincipal;
	}

	public void setCodigoDiagnosticoPrincipal(String codigoDiagnosticoPrincipal) {
		this.codigoDiagnosticoPrincipal = codigoDiagnosticoPrincipal;
	}

	public String getCodigoDiagnosticoRelacionado() {
		return codigoDiagnosticoRelacionado;
	}

	public void setCodigoDiagnosticoRelacionado(String codigoDiagnosticoRelacionado) {
		this.codigoDiagnosticoRelacionado = codigoDiagnosticoRelacionado;
	}

	public RegistroHistoriaClinica getRegistroHistoriaClinica() {
		return registroHistoriaClinica;
	}

	public void setRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		this.registroHistoriaClinica = registroHistoriaClinica;
	}

}
