package com.crystalcrumbs.advice;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crystalcrumbs.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvise {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleTouistException (TouristNotFoundException exp){
		
		ErrorDetail error = new ErrorDetail(exp.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleException (Exception exp){
		
		ErrorDetail error = new ErrorDetail(exp.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
