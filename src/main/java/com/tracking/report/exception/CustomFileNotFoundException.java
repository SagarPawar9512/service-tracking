package com.tracking.report.exception;

public class CustomFileNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CustomFileNotFoundException(){
		super();
	}
	
	public CustomFileNotFoundException(String message, Throwable cause){
		super(message,cause);
	}
	

}
