package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Appointment;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

	@GetMapping
	public List<Appointment> getAppointments(){
		return null;
	}
	
	@GetMapping("{id}")
	public Appointment getAppointment(@PathVariable int id) {
		return null;
	}
	
	@PostMapping
	public void addAppointment(@RequestBody Appointment appointment) {
		
	}
	
}
