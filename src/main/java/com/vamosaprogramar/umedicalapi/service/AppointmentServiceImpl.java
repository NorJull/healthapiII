package com.vamosaprogramar.umedicalapi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.ALL_DOCTORS_ID;
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

	@Override
	public String getNumberOfAvailableAppointments(int specialityId, int doctorId, int year, int month) {
		
		if(specialityId != 0 && doctorId != 0) {
	//		appointmentDAO.getNumberOfAvailableAppointments(specialityId,doctorId);
		}
		
		return null;
	}

	@Override
	public List<Appointment> getRegisteredAppointments(int specialityId, int doctorId, int year, int month) {
		LocalDate startDate = LocalDate.of(year, month, 1);
		LocalDate finishDate = startDate.plusMonths(1);
		
		if(doctorId == ALL_DOCTORS_ID) {
			
			
			List<Appointment> appointments =	appointmentDAO.getRegisteredAppointmentsOfAllDoctors(specialityId, startDate, finishDate) ;
			return appointments;
		}else {
			List<Appointment> appointments = appointmentDAO.getRegisteredAppointmentsOfOneDoctor(specialityId, doctorId, startDate, finishDate) ;
			;
			return appointments;
		}

	}

}
