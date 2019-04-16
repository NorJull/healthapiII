package com.vamosaprogramar.umedicalapi.service;

import java.util.List;
import java.util.Map;

import com.vamosaprogramar.umedicalapi.entity.Appointment;

public interface AppointmentService {

	public List<Appointment> getAppointments();
	
	public Appointment getAppointment(int id);
	
	public void addAppointment(Appointment appointment);

	public Map<Integer, Integer> getNumberOfAvailableAppointments(int specialityId, int doctorId, int year, int month);

	public List<Appointment> getRegisteredAppointments(int specialityId, int doctorId, int year, int month);

	public void toCancelAnAppointment(int id);

	public List<Appointment> getAppointmentByPatient(int patientId);

	public List<Appointment> getRegisteredAppointmentsPerPatient(int patientId);

	List<Appointment> getRegisteredAppointmentsOfTheDay(int specialityId, int doctorId, int year, int month, int day);

	public List<Appointment> registeredAppointmentsOfTheCurrentDay(int doctorId, int specialityId);
	
}
