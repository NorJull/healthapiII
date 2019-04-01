package com.vamosaprogramar.umedicalapi.exception;

public class PatientDoesNotExist extends Exception{
	
	public PatientDoesNotExist(String document, String documentType) {
		
		super("There is no patient in the database with document "+document+" and document type "+documentType);
	}

}
