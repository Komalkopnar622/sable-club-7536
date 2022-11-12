package com.masai.Exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<MyErrorDetail> myExpHandler1(InvalidId ie,WebRequest wr)
	{
		MyErrorDetail err= new MyErrorDetail(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
	    return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(BookingNotFoundException se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserAlreadyExistWithuserId.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(UserAlreadyExistWithuserId ue, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ue.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(InvalidPasswordException ie, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Nullexception.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(Nullexception nue, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(nue.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(NotFoundException ne, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ne.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<MyErrorDetail> employeeExceptionHandler(DriverNotFoundException se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	

}
