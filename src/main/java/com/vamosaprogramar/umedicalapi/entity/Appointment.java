package com.vamosaprogramar.umedicalapi.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;

import com.fasterxml.jackson.annotation.JsonFormat;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;
import com.vamosaprogramar.umedicalapi.LocalDateConverter;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name="date_")
	@Convert(converter = LocalDateConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate date;
	
	@Column(name = "time_")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  time;
	
	@Column(name = "state")
	private String state;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "applicationuser_id")
	private ApplicationUser applicationUser;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "speciality_id")
	private Especialidad speciality;

	@Column(name = "es_particular")
	private String esParticular;
	
	@Column(name = "cup")
	private String cup;

	public Appointment() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	public ApplicationUser getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser) {
		this.applicationUser = applicationUser;
	}

	public Especialidad getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Especialidad speciality) {
		this.speciality = speciality;
	}


	public String getEsParticular() {
		return esParticular;
	}

	public void setEsParticular(String esParticular) {
		this.esParticular = esParticular;
	}

	public String getCup() {
		return cup;
	}

	public void setCup(String cup) {
		this.cup = cup;
	}	
	
}
