package com.app.customexception;

@SuppressWarnings("serial")

public class NewException extends Exception{
public NewException(String errmsg) {
	super(errmsg);//we must declare a constructor here else it gives null err msg
}
	
}
