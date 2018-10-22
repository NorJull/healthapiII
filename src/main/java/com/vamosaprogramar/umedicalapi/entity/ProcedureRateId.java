package com.vamosaprogramar.umedicalapi.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class ProcedureRateId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6446623148389138535L;
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name= "rate_manual_id")
	private RateManual rateManual;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name= "procedure_type_id")
	private ProcedureType procedureType;

	public ProcedureRateId() {

	}
	
	
	public ProcedureRateId(RateManual rateManual, ProcedureType procedureType) {
		super();
		this.rateManual = rateManual;
		this.procedureType = procedureType;
	}


	public RateManual getRateManual() {
		return rateManual;
	}


	public void setRateManual(RateManual rateManual) {
		this.rateManual = rateManual;
	}


	public ProcedureType getProcedureType() {
		return procedureType;
	}


	public void setProcedureType(ProcedureType procedureType) {
		this.procedureType = procedureType;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procedureType == null) ? 0 : procedureType.hashCode());
		result = prime * result + ((rateManual == null) ? 0 : rateManual.hashCode());
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
		ProcedureRateId other = (ProcedureRateId) obj;
		if (procedureType == null) {
			if (other.procedureType != null)
				return false;
		} else if (!procedureType.equals(other.procedureType))
			return false;
		if (rateManual == null) {
			if (other.rateManual != null)
				return false;
		} else if (!rateManual.equals(other.rateManual))
			return false;
		return true;
	}
	



	
	
}
