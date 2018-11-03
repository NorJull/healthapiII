package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.ApplicationUser;
import com.vamosaprogramar.umedicalapi.entity.Appointment;
import com.vamosaprogramar.umedicalapi.entity.Patient;
import com.vamosaprogramar.umedicalapi.entity.Speciality;
import com.vamosaprogramar.umedicalapi.service.AppointmentService;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService; 
	
	@GetMapping
	public List<Appointment> getAppointments(){
		return appointmentService.getAppointments();
	}
	
	@GetMapping("{id}")
	public Appointment getAppointment(@PathVariable int id) {
				
		return appointmentService.getAppointment(id);
	}
	
	@PostMapping
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentService.addAppointment(appointment);
	}
	
}
