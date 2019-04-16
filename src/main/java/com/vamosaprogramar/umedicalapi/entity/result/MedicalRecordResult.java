package com.vamosaprogramar.umedicalapi.entity.result;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.DATE_FORMAT;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TIME_FORMAT;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MedicalRecordResult {

	private int id;
	
	private int patientId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
	private LocalDate date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = TIME_FORMAT)
	private LocalTime  time;

	private String particular;
	
	private String consultationReason;
	
	public MedicalRecordResult() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getConsultationReason() {
		return consultationReason;
	}

	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}
	
	
}
