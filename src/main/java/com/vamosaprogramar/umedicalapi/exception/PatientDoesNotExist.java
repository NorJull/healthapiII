package com.vamosaprogramar.umedicalapi.exception;

public class PatientDoesNotExist extends Exception{
	
	public PatientDoesNotExist(String document) {
		
		super("There is no patient in the database with document "+document);
	}

}
