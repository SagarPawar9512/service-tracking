package com.tracking.report.exception;

public class ExceptionResponse {
	
	String description;

	public ExceptionResponse(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
