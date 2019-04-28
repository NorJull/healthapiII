package com.vamosaprogramar.umedicalapi.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tarifa_procedimiento")
public class TarifaProcedimiento {

	@EmbeddedId
	private ProcedureRateId id;
	
	@Column(name="valor")
	private double valor;

	public TarifaProcedimiento() {
		
	} 
	
	public TarifaProcedimiento(ProcedureRateId id, double value) {
		
		this.id = id;
		this.valor = value;
	}

	public ProcedureRateId getId() {
		return id;
	}

	public void setId(ProcedureRateId id) {
		this.id = id;
	}

	public double getValue() {
		return valor;
	}

	public void setValue(double value) {
		this.valor = value;
	}

	@Override
	public String toString() {
		return "ProcedureRate [id=" + id.getProcedureType().getCup() + ", value=" + valor + "]";
	}
	
	
	
	
}
