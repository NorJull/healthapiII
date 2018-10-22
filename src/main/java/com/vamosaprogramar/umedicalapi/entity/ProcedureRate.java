package com.vamosaprogramar.umedicalapi.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "procedure_rate")
public class ProcedureRate {

	@EmbeddedId
	private ProcedureRateId id;
	
	@Column(name="value_")
	private double value;

	public ProcedureRate() {
		
	} 
	
	public ProcedureRate(ProcedureRateId id, double value) {
		
		this.id = id;
		this.value = value;
	}

	public ProcedureRateId getId() {
		return id;
	}

	public void setId(ProcedureRateId id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ProcedureRate [id=" + id.getProcedureType().getCup() + ", value=" + value + "]";
	}
	
	
	
	
}
