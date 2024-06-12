package com.petstoreapplication.custom_exception;

public class OutOfStockException extends Exception {
  
	 public OutOfStockException(String errmesg) {
		 super(errmesg);
	}
	
}
