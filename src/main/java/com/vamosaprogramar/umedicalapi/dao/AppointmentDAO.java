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
}
