package com.petstoreapplication.custom_exception;

public class AuthorisationException extends Exception {

	public AuthorisationException(String errmesg) {
		super(errmesg);
	}
}
