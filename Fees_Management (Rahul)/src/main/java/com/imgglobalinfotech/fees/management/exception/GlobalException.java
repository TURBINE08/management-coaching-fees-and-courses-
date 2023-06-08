package com.imgglobalinfotech.fees.management.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//import com.example.demo.exception.ResourceNotFoundExceptions;
import com.imgglobalinfotech.fees.management.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptions(ResourceNotFoundExceptions ex) {
		String umessage = "user not found";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiResponse> DataIntegrityViolationException(MethodArgumentTypeMismatchException ex) {
		String umessage = "please enter correct input";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			String status = "Status";
			String Boolean = "false";
			map.put(status, Boolean);
			map.put(fieldname, message);
		});

		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND); 
	}
	@ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
	public ResponseEntity<?> datntegrityViolationException(org.springframework.dao.DataIntegrityViolationException ex) {
		Map<String, String> map = new HashMap<>();
		String fieldname = "enter proper date";
		String message = "message";
		String status = "Status";
		String Boolean = "false";
		map.put(status, Boolean);
		map.put(message, fieldname);
		return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);  
	}
	
	@ExceptionHandler(JpaSystemException.class)
	public ResponseEntity<ApiResponse> jpaSystemException(JpaSystemException ex) {
		String umessage = "please check your flow of programm and also database ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> rttprequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
		String umessage = "please check your API method (post, get, delete......) ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class) 
	public ResponseEntity<ApiResponse> invalidDataAccessApiUsageException(InvalidDataAccessApiUsageException ex) {
		String umessage = "please check your annotation on query @Modifying	@Transactional ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class) 
	public ResponseEntity<ApiResponse> httpmessageNotReadableException(HttpMessageNotReadableException ex) {
		String umessage = "Json object is not created please enter proper value";
		String message = ex.getMessage();
//		String message = ex.fillIn;
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)  
	public ResponseEntity<ApiResponse> noSuchElementException(NoSuchElementException ex) {
		String umessage = "no such element are present please check input data ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IndexOutOfBoundsException.class) 
	public ResponseEntity<ApiResponse> ndexOutOfBoundsException(IndexOutOfBoundsException ex) {
		String umessage = "no such admin id is present in database please check input data ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class) 
	public ResponseEntity<ApiResponse> emptyResultDataAccessException(EmptyResultDataAccessException ex) {
		String umessage = "no such data is present in data base ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IncorrectResultSizeDataAccessException.class)  
	public ResponseEntity<ApiResponse> incorrectResultSizeDataAccessException(IncorrectResultSizeDataAccessException ex) {
		String umessage = "multiple records are present  ";
		String message = ex.getMessage();
		ApiResponse apiresponse = new ApiResponse(umessage, message, false);
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
	}

	
}
