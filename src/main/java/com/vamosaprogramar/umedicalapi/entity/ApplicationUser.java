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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="applicationuser")
public class ApplicationUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	// Primer apellido
	@Column(name = "last_name_1")
	private String lastName1;

	// Segundo apellido
	@Column(name = "last_name_2")
	private String lastName2;

	// Primer nombre
	@Column(name = "name_1")
	private String name1;

	// Segundo nombre
	@Column(name = "name_2")
	private String name2;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name="document")
	private String document;
	
	@Column(name="user_type")
	private String userType;
	
	@Column(name="professional_card")
	private String professionalCard;
	

	@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "applicationuser_speciality", 
        joinColumns = { @JoinColumn(name = "user_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "speciality_id") }
    )
	private List<Speciality> specialities;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Schedule> schedules;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="patient",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Appointment> appointments; 
		

	@JsonIgnore
	@Column(name="password")
	private String password;

	
	public ApplicationUser() {
		
	}


	public ApplicationUser(String username, String password) {

		this.username = username;
		this.password = password;
	}


	public ApplicationUser(int id, String username, String document, String userType, String professionalCard,
			String password) {

		this.id = id;
		this.username = username;
		this.document = document;
		this.userType = userType;
		this.professionalCard = professionalCard;
		this.password = password;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	public String getProfessionalCard() {
		return professionalCard;
	}


	public void setProfessionalCard(String professionalCard) {
		this.professionalCard = professionalCard;
	}


	public int getId() {
		return id;
	}


	public String getLastName1() {
		return lastName1;
	}


	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}


	public String getLastName2() {
		return lastName2;
	}


	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}


	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}


	public String getName2() {
		return name2;
	}


	public void setName2(String name2) {
		this.name2 = name2;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	
	public List<Speciality> getSpecialities() {
		return specialities;
	}


	public void setSpecialities(List<Speciality> specialities) {
		this.specialities = specialities;
	}

	@JsonIgnore
	public List<Schedule> getSchedules() {
		return schedules;
	}

	@JsonProperty
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	public void addSchedule(Schedule schedule) {
		if(schedules==null) {
			schedules = new ArrayList<>();
		}
		schedules.add(schedule);
		
		schedule.setUser(this);
	}
	
	public void addSpeciality(Speciality speciality) {
		if(specialities==null) {
			specialities = new ArrayList<Speciality>();
		}
		specialities.add(speciality);
		
		speciality.addUser(this);
	}
	
	public void removeSpeciality(Speciality speciality) {
		if (speciality==null) {
			specialities = new ArrayList<Speciality>();
		}
		
		if(specialities.remove(speciality)) {
			speciality.getUsers().remove(this);
		}
	}
	public void addAppointment(Appointment appointment) {
		if(appointments==null) {
			appointments = new ArrayList<>();
		}
		appointments.add(appointment);
		appointment.setApplicationUser(this);
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", username=" + username + ", lastName1=" + lastName1 + ", lastName2="
				+ lastName2 + ", name1=" + name1 + ", name2=" + name2 + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", document=" + document + ", userType=" + userType + ", professionalCard=" + professionalCard
				+ ", password=" + password + "]";
	}

	
	

}

