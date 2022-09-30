package com.tracking.report.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.opencsv.exceptions.CsvException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomFileNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse handleFileNotFoundException(CustomFileNotFoundException exception,
			 HttpServletRequest request){
		ExceptionResponse response=new ExceptionResponse(exception.getMessage()) ;
		return response;
		
	}
	
	@ExceptionHandler(value = {MiscException.class,IOException.class,CsvException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleMiscException(MiscException exception,
			 HttpServletRequest request){
		ExceptionResponse response=new ExceptionResponse(exception.getMessage()) ;
		return response;
		
	}

}
