package com.vamosaprogramar.umedicalapi.exception;

public class IncompleteRow extends Exception {
	
	public IncompleteRow() {
		super("The row is incomplete.");
	}
}
