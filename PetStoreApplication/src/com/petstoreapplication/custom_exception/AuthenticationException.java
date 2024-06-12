package com.petstoreapplication.custom_exception;

public class AuthenticationException extends Exception{

	public AuthenticationException(String errmsg) {
		super(errmsg);
}
}