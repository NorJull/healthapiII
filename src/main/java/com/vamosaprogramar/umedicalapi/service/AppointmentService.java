package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Appointment;

public interface AppointmentService {

	public List<Appointment> getAppointments();
	
	public Appointment getAppointment(int id);
	
	public void addAppointment(Appointment appointment);

	public String getNumberOfAvailableAppointments(int specialityId, int doctorId, int year, int month);

	public List<Appointment> getRegisteredAppointments(int specialityId, int doctorId, int year, int month);

	public List<Appointment> getAppointments(int specialityId, int doctorId, int year, int month, int day);

	public void toCancelAnAppointment(int id);

	public List<Appointment> getAppointmentByPatient(int patientId);
	
}