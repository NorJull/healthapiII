package com.vamosaprogramar.umedicalapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "medicamento_odontologia")
public class MedicamentoOdontologia {

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
	@JoinColumn(name = "registro_odontologia_id")
	private RegistroOdontologia registroOdontologia;

	public MedicamentoOdontologia() {
	
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

	public RegistroOdontologia getRegistroOdontologia() {
		return registroOdontologia;
	}

	public void setRegistroOdontologia(RegistroOdontologia registroOdontologia) {
		this.registroOdontologia = registroOdontologia;
	}
}
