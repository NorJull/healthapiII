package com.vamosaprogramar.umedicalapi.exception;

public class UserDoesNotExist extends Exception {
	
	public UserDoesNotExist() {
		super("The user does not exist!");
	}
}
