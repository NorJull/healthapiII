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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "procedure_type")
public class ProcedureType {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "cup", unique = true)
	private String cup;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "procedureTypes")
	private List<Speciality> specialities;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "procedureTypes")
	private List<Contract> contracts;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="procedureType",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Procedure> procedures;
	
	public ProcedureType() {
		// TODO Auto-generated constructor stub
	}
	
	public ProcedureType(int id, String cup, String description) {
		this.id = id;
		this.cup = cup;
		this.description = description;
	}

	

	public int getId() {
		return id;
	}

	public List<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public List<Contract> getContracts() {
		if(contracts== null) {
			contracts = new ArrayList<Contract>();
		}
		
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cup == null) ? 0 : cup.hashCode());
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
		ProcedureType other = (ProcedureType) obj;
		if (cup == null) {
			if (other.cup != null)
				return false;
		} else if (!cup.equals(other.cup))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ProcedureType [id=" + id + ", cup=" + cup + ", description=" + description + "]";
	}
	
}
