package com.vamosaprogramar.umedicalapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamosaprogramar.umedicalapi.entity.enumerable.HealthEntityType;

@Entity
@Table(name = "health_entity")
public class HealthEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="health_entity_type")	
	private HealthEntityType healthEntityType;

	@Column(name = "name_")
	private String name;
	
	@Column(name = "reps")
	private String reps;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER ,mappedBy="healthEntity",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Contract> contracts; 
	
	

	
	public HealthEntity() {
		
	}
	
	public HealthEntity(int id, HealthEntityType healthEntityType, String name, String reps) {
		
		this.id = id;
		this.healthEntityType = healthEntityType;
		this.name = name;
		this.reps = reps;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HealthEntityType getHealthEntityType() {
		return healthEntityType;
	}

	public void setHealthEntityType(HealthEntityType healthEntityType) {
		this.healthEntityType = healthEntityType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReps() {
		return reps;
	}

	public void setReps(String reps) {
		this.reps = reps;
	}
	
	
	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public void addContract(Contract tempContract) {
		
		if(contracts == null) {
			contracts = new ArrayList<Contract>();
		}
		
		contracts.add(tempContract);
		
		tempContract.setHealthEntity(this);
		
	}

	@Override
	public String toString() {
		return "HealthEntity [id=" + id + ", healthEntityType=" + healthEntityType + ", name=" + name + ", reps=" + reps
				+ "]";
	}
	
	
	
	
}
