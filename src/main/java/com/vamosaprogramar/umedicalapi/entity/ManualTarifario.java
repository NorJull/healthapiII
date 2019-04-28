package com.vamosaprogramar.umedicalapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manual_tarifario")
public class ManualTarifario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "descripcion")
	private String descripcion;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "manualTarifario", cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Contrato> contratos;

	public ManualTarifario() {
		super();
	}

	public ManualTarifario(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public void addContract(Contrato tempContract) {

		if (contratos == null) {
			contratos = new ArrayList<Contrato>();
		}

		contratos.add(tempContract);

		tempContract.setRateManual(this);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManualTarifario other = (ManualTarifario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
