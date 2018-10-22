package com.vamosaprogramar.umedicalapi.exception;

public class ProcedureTypeDoesNotExist extends Exception {

	public ProcedureTypeDoesNotExist(String cup) {
		super("There is no procedure in the database with CUP "+cup);
	}
}
