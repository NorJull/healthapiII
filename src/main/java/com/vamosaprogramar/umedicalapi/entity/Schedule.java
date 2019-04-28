package com.vamosaprogramar.umedicalapi.entity;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;
@Entity
@Table(name="schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="week_day")
	private int weekDay;
	
	@Column(name = "start_time_turn_one")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  startTimeTurnOne;
	
	@Column(name = "start_time_turn_two")
	@Convert(converter = LocalTimeConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  startTimeTurnTwo;
	
	
	@Column(name = "appointments_turn_one")
	private int appointmentsTurnOne;
	
	@Column(name = "appointments_turn_two")
	private int appointmentsTurnTwo;
	
	@JsonIgnore
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private ApplicationUser user;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "specialty_id")
	private Especialidad speciality;

	public Schedule() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}



	public LocalTime getStartTimeTurnOne() {
		return startTimeTurnOne;
	}

	public void setStartTimeTurnOne(LocalTime startTimeTurnOne) {
		this.startTimeTurnOne = startTimeTurnOne;
	}

	public LocalTime getStartTimeTurnTwo() {
		return startTimeTurnTwo;
	}

	public void setStartTimeTurnTwo(LocalTime startTimeTurnTwo) {
		this.startTimeTurnTwo = startTimeTurnTwo;
	}

	public int getAppointmentsTurnOne() {
		return appointmentsTurnOne;
	}

	public void setAppointmentsTurnOne(int appointmentsTurnOne) {
		this.appointmentsTurnOne = appointmentsTurnOne;
	}

	public int getAppointmentsTurnTwo() {
		return appointmentsTurnTwo;
	}

	public void setAppointmentsTurnTwo(int appointmentsTurnTwo) {
		this.appointmentsTurnTwo = appointmentsTurnTwo;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public Especialidad getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Especialidad speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", weekDay=" + weekDay + ", startTimeTurnOne=" + startTimeTurnOne
				+ ", startTimeTurnTwo=" + startTimeTurnTwo + ", appointmentsTurnOne=" + appointmentsTurnOne
				+ ", appointmentsTurnTwo=" + appointmentsTurnTwo + "]";
	}
	
	 
	
}
