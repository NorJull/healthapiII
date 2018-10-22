package com.vamosaprogramar.umedicalapi.exception;

public class ScheduleException extends Exception {
	
	public ScheduleException() {
		super(" There are scheduled appointments. You can not change the schedule!");
	}
}
