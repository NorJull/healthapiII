package com.vamosaprogramar.umedicalapi.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.ALL_DOCTORS_ID;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.MONDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.TUESDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.WEDNESDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.THURSDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.FRIDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.SATURDAY;
import static com.vamosaprogramar.umedicalapi.GeneralConstants.SUNDAY;

import static com.vamosaprogramar.umedicalapi.GeneralConstants.APPOINTMENT_STATE_SCHEDULED;
import com.vamosaprogramar.umedicalapi.dao.AppointmentDAO;
import com.vamosaprogramar.umedicalapi.dao.ScheduleDAO;
import com.vamosaprogramar.umedicalapi.entity.Appointment;
import com.vamosaprogramar.umedicalapi.entity.Schedule;
import static com.vamosaprogramar.umedicalapi.util.DateUtility.getFinishDayOfTheMonth;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDAO appointmentDAO;

	@Autowired
	private ScheduleDAO scheduleDAO;

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
	public Map<Integer, Integer> getNumberOfAvailableAppointments(int specialityId, int doctorId, int year, int month) {
		LocalDate startDate = LocalDate.of(year, month, 1);
		LocalDate finishDate = startDate.plusMonths(1);
		int day;
		int value;
		List<Schedule> schedules;
		List<Appointment> appointments;

		System.out.println("PASO 1");
		if (doctorId == ALL_DOCTORS_ID) {
			System.out.println("PASO 1.1");
			schedules = scheduleDAO.getScheduleOfOneSpeciality(specialityId);

			appointments = appointmentDAO.getRegisteredAppointmentsOfAllDoctors(specialityId, startDate, finishDate);

		} else {
			System.out.println("PASO 1.2");
			schedules = scheduleDAO.getScheduleByDoctorAndSpeciality(specialityId, doctorId);

			appointments = appointmentDAO.getRegisteredAppointmentsOfOneDoctor(specialityId, doctorId, startDate,
					finishDate);
		}
		System.out.println("PASO 2");
		// Contendra el número de citas que puede atender el doctor en los dias de la
		// semana
		Map<Integer, Integer> mapSchedule = new HashMap<>();

		mapSchedule.put(1, 0);
		mapSchedule.put(2, 0);
		mapSchedule.put(3, 0);
		mapSchedule.put(4, 0);
		mapSchedule.put(5, 0);
		mapSchedule.put(6, 0);
		mapSchedule.put(7, 0);
		for (Schedule schedule : schedules) {
			value = mapSchedule.get(schedule.getWeekDay());

			mapSchedule.put(schedule.getWeekDay(),
					value + schedule.getAppointmentsTurnOne() + schedule.getAppointmentsTurnTwo());
		}
		System.out.println("PASO 3");
		// Contendra el número de citas disponibles que el doctor tiene en cada día del
		// mes
		Map<Integer, Integer> mapAppointments = new HashMap<>();

		System.out.println("******************************111111111111*************************************");
		System.out.println(mapAppointments);
		
		LocalDate localDate = LocalDate.of(year, month, 1);
		int dayOfWeek;
		for (int i = 1; i <= getFinishDayOfTheMonth(year, month); i++) {
			dayOfWeek = localDate.getDayOfWeek().getValue();

			switch (dayOfWeek) {
			case MONDAY:
				mapAppointments.put(i, mapSchedule.get(MONDAY));
				break;
			case TUESDAY:
				mapAppointments.put(i, mapSchedule.get(TUESDAY));
				break;
			case WEDNESDAY:
				mapAppointments.put(i, mapSchedule.get(WEDNESDAY));
				break;
			case THURSDAY:
				mapAppointments.put(i, mapSchedule.get(THURSDAY));
				break;
			case FRIDAY:
				mapAppointments.put(i, mapSchedule.get(FRIDAY));
				break;
			case SATURDAY:
				mapAppointments.put(i, mapSchedule.get(SATURDAY));
				break;
			case SUNDAY:
				mapAppointments.put(i, mapSchedule.get(SUNDAY));
				break;
			default:
				break;
			}
			localDate = localDate.plusDays(1);
		}

		System.out.println("***************************2222222222222222****************************************");
		System.out.println(mapAppointments);
		
		for (Appointment appointment : appointments) {

			day = appointment.getDate().getDayOfMonth();

			value = mapAppointments.get(day);

			mapAppointments.put(day, value - 1);

		}
		System.out.println("*************************33333333333333333333333******************************************");
		System.out.println(mapAppointments);
		
		return mapAppointments;
	}

	@Override
	public List<Appointment> getRegisteredAppointments(int specialityId, int doctorId, int year, int month) {
		LocalDate startDate = LocalDate.of(year, month, 1);
		LocalDate finishDate = startDate.plusMonths(1);

		if (doctorId == ALL_DOCTORS_ID) {

			List<Appointment> appointments = appointmentDAO.getRegisteredAppointmentsOfAllDoctors(specialityId,
					startDate, finishDate);
			return appointments;
		} else {
			List<Appointment> appointments = appointmentDAO.getRegisteredAppointmentsOfOneDoctor(specialityId, doctorId,
					startDate, finishDate);
			;
			return appointments;
		}

	}

	@Override
	public List<Appointment> getRegisteredAppointmentsOfTheDay(int specialityId, int doctorId, int year, int month, int day) {

		LocalDate dayDate = LocalDate.of(year, month, day);

		return appointmentDAO.getRegisteredAppointmentsOfTheDay(specialityId, doctorId, dayDate);

	}

	@Override
	public void toCancelAnAppointment(int id) {

		appointmentDAO.toCancelAnAppointment(id);

	}

	@Override
	public List<Appointment> getAppointmentByPatient(int patientId) {

		return appointmentDAO.getAppointmentByPatient(patientId);
	}

	@Override
	public List<Appointment> getRegisteredAppointmentsPerPatient(int patientId) {
		return appointmentDAO.getAppointmentByPatientByState(patientId, APPOINTMENT_STATE_SCHEDULED);
	}

}
