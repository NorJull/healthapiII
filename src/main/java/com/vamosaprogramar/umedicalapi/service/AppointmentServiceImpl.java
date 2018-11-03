package com.vamosaprogramar.umedicalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vamosaprogramar.umedicalapi.dao.AppointmentDAO;
import com.vamosaprogramar.umedicalapi.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentDAO appointmentDAO;
	
	@Override
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointments();
	}

	@Override
	public Appointment getAppointment(int id) {
		// TODO Auto-generated method stub
		return appointmentDAO.getAppointment(id);
	}

	@Override
	public void addAppointment(Appointment appointment) {
		
		appointmentDAO.addAppointment(appointment);
		
	}

}
