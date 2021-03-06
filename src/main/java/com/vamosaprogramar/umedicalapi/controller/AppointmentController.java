package com.vamosaprogramar.umedicalapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vamosaprogramar.umedicalapi.entity.Appointment;
import com.vamosaprogramar.umedicalapi.service.AppointmentService;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	public List<Appointment> getAppointments() {
		return appointmentService.getAppointments();
	}

	@GetMapping("{id}")
	public Appointment getAppointment(@PathVariable int id) {
		return appointmentService.getAppointment(id);
	}

	@GetMapping("/reschedule/{patientId}")
	public List<Appointment> getAppointmentByPatient(@PathVariable int patientId) {

		return appointmentService.getAppointmentByPatient(patientId);
	}
	@GetMapping("registeredAppointmentsOfTheCurrentDay/{doctorId}/{specialityId}")
	public List<Appointment> getRegisteredAppoinmentsOfTheCurrentDay(@PathVariable int doctorId, @PathVariable int specialityId){
		return appointmentService.registeredAppointmentsOfTheCurrentDay(doctorId, specialityId);
	}
	
	@GetMapping("{specialityId}/{doctorId}/{year}/{month}")
	public Map<Integer, Integer> getNumberOfAvailableAppointments(@PathVariable int specialityId, @PathVariable int doctorId,
			@PathVariable int year, @PathVariable int month) {
		
		return appointmentService.getNumberOfAvailableAppointments(specialityId, doctorId, year, month);
	
	}
	
	@GetMapping("registeredAppointments/{specialityId}/{doctorId}/{year}/{month}")
	public List<Appointment> getRegisteredAppointments(@PathVariable int specialityId, @PathVariable int doctorId,
			@PathVariable int year, @PathVariable int month) {
		return appointmentService.getRegisteredAppointments(specialityId, doctorId, year, month);
	}

	@GetMapping("registeredAppointmentsPerPatient/{patientId}")
	public List<Appointment> getRegisteredAppointmentsPerPatient(@PathVariable int patientId) {
		return appointmentService.getRegisteredAppointmentsPerPatient(patientId);
	}
	
	@GetMapping("registeredAppointments/{specialityId}/{doctorId}/{year}/{month}/{day}")
	public List<Appointment> getRegisteredAppointmentsOfTheDay(@PathVariable int specialityId, @PathVariable int doctorId,
			@PathVariable int year, @PathVariable int month, @PathVariable int day) {
		return appointmentService.getRegisteredAppointmentsOfTheDay(specialityId, doctorId, year, month, day);
	}

	@PostMapping
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentService.addAppointment(appointment);
	}

	@PutMapping("toCancel/{id}")
	public void toCancelAnAppointment(@PathVariable int id) {
		appointmentService.toCancelAnAppointment(id);
	}

}
