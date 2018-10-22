package com.vamosaprogramar.umedicalapi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "departament")
public class Departament {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="departament",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Patient> patients;

	public Departament() {
		
	}

	public Departament(int id, String name, List<Patient> patients) {
	
		this.id = id;
		this.name = name;
		this.patients = patients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

public void addPatient(Patient patient) {
		
		if(patients == null) {
			patients = new ArrayList<Patient>();
		}
		patients.add(patient);
		
		patient.setDepartament(this);
	}
}
