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
@Table(name = "medicamento")
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "medicina")
	private String medicina;
	
	@Column(name = "concentracion")
	private String concentracion;
	
	@Column(name = "presentacion")
	private String presentacion;
	
	@Column(name = "unidades")
	private int unidades;
	
	@Column(name = "posologia")
	private String posologia;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "registro_historia_clinica_id")
	private RegistroHistoriaClinica registroHistoriaClinica;
	
	public Medicamento() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMedicina() {
		return medicina;
	}

	public void setMedicina(String medicina) {
		this.medicina = medicina;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	public RegistroHistoriaClinica getRegistroHistoriaClinica() {
		return registroHistoriaClinica;
	}

	public void setRegistroHistoriaClinica(RegistroHistoriaClinica registroHistoriaClinica) {
		this.registroHistoriaClinica = registroHistoriaClinica;
	}

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", medicina=" + medicina + ", concentracion=" + concentracion
				+ ", presentacion=" + presentacion + ", unidades=" + unidades + ", posologia=" + posologia + "]";
	}
	
	
}
