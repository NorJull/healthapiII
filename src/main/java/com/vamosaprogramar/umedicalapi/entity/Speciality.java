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

@Entity
@Table(name = "speciality")
public class Speciality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "position_name")
	private String positionName;
	
	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
        name = "speciality_procedureType", 
        joinColumns = { @JoinColumn(name = "speciality_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "procedure_type_id") }
    )
	private List<ProcedureType> procedureTypes;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "specialities")
	private List<ApplicationUser> users;
	
	@JsonIgnore
	@OneToMany(mappedBy="speciality",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Schedule> schedules;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY ,mappedBy="patient",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Appointment> appointments; 
	
	public Speciality() {
	
	}
	
	
	public Speciality(int id, String description) {

		this.id = id;
		this.description = description;
	}
	
	
	public Speciality(int id, String description, String positionName) {
		super();
		this.id = id;
		this.description = description;
		this.positionName = positionName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<ProcedureType> getProcedureTypes() {
		return procedureTypes;
	}


	public void setProcedureTypes(List<ProcedureType> procedureTypes) {
		this.procedureTypes = procedureTypes;
	}


	public List<ApplicationUser> getUsers() {
		return users;
	}


	public void setUsers(List<ApplicationUser> users) {
		this.users = users;
	}


	public String getPositionName() {
		return positionName;
	}


	public List<Schedule> getSchedules() {
		return schedules;
	}


	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}


	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}


	public void addUser(ApplicationUser user) {
		
		if(users==null) {
			users = new ArrayList<ApplicationUser>();
		}
		
		users.add(user);
		
		
	}

	public void addProcedureType(ProcedureType procedureType) {
		
		if(procedureTypes==null) {
			procedureTypes = new ArrayList<ProcedureType>();
		}
		
		procedureTypes.add(procedureType);
		
		procedureType.getSpecialities().add(this);
		
	}

	public void removeProcedureType(ProcedureType procedureType) {
		
		if(procedureTypes==null) {
			procedureTypes = new ArrayList<ProcedureType>();
		}
		if(procedureTypes.remove(procedureType)) {
			
			procedureType.getSpecialities().remove(this);
		}
		
	}

	public void addAppointment(Appointment appointment) {
		if(appointments==null) {
			appointments = new ArrayList<>();
		}
		appointments.add(appointment);
		appointment.setSpeciality(this);
	}
	
}
