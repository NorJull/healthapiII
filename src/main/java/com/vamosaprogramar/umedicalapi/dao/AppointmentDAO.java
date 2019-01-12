package com.vamosaprogramar.umedicalapi.dao;

import java.time.LocalDate;
import java.util.List;

import com.vamosaprogramar.umedicalapi.entity.Appointment;

public interface AppointmentDAO {
	
	public List<Appointment> getAppointments();
	
	public Appointment getAppointment(int id);
	
	public void addAppointment(Appointment appointment);

	public List<Appointment> getRegisteredAppointmentsOfAllDoctors(int specialityId, LocalDate startDate, LocalDate finishDate);

	public List<Appointment> getRegisteredAppointmentsOfOneDoctor(int specialityId, int doctorId, LocalDate startDate, LocalDate finishDate);

	public List<Appointment> getAppointments(int specialityId, int doctorId, LocalDate dayDate);

	public void toCancelAnAppointment(int id);

	public List<Appointment> getAppointmentByPatient(int patientId);
}