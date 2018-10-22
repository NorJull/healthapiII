package com.vamosaprogramar.umedicalapi.exception;

public class DuplicateProcedureRate extends Exception {
	
	public DuplicateProcedureRate() {
		super("There is already a database registry with this manual and this type of procedure");
	}
}
