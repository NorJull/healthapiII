package com.vamosaprogramar.umedicalapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "remision")
public class Remision {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre_eps")
	private String nombreEps;
	
	@Column(name = "codigo_diagnostico_principal")
	private String codigoDiagnosticoPrincipal;
	
	@Column(name = "especialidad")
	private String especialidad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "registro_historia_clinica_id")
	private RegistroHistoriaClinica registroHistoriaClinica;
	
	public Remision() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreEps() {
		return nombreEps;
	}

	public void setNombreEps(String nombreEps) {
		this.nombreEps = nombreEps;
	}

	public String getCodigoDiagnosticoPrincipal() {
		return codigoDiagnosticoPrincipal;
	}

	public void setCodigoDiagnosticoPrincipal(String codigoDiagnosticoPrincipal) {
		this.codigoDiagnosticoPrincipal = codigoDiagnosticoPrincipal;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public RegistroHistoriaClinica getRegistroHistoriaClinica() {
		return registroHistoriaClinica;
	}

	public void setRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		this.registroHistoriaClinica = registroHistoriaClinica;
	}
	
	
	
}
