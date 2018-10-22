package com.vamosaprogramar.umedicalapi.exception;

public class DuplicateProcedureType extends Exception {
	
	public DuplicateProcedureType() {
		super("There is already a database registry with this type of procedure");
	}
}
