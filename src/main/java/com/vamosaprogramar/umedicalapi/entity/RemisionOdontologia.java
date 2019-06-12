package com.vamosaprogramar.umedicalapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "remision_odontologia")
public class RemisionOdontologia {

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
	@JoinColumn(name = "registro_odontologia_id")
	private RegistroOdontologia registroOdontologia;

	public RemisionOdontologia() {
		
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

	public RegistroOdontologia getRegistroOdontologia() {
		return registroOdontologia;
	}

	public void setRegistroOdontologia(RegistroOdontologia registroOdontologia) {
		this.registroOdontologia = registroOdontologia;
	}
}
