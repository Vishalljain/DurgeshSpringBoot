package com.infybuzz.cloud.Exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice // this class is annotatted with @Controller advice to tell this is the place
					// where all the exception are handled

public class GlobalException extends ResponseEntityExceptionHandler {

	//the below all method are override n already marked with @ExceptionHandler so dont want to mark again u can go n see implementation plan
	
	
	// the client is support to send json data but he send xml data
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {// this method have status code like 200 will
																			// directly pass
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Media Type not supported");
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}

	// if the user does not send data in request body then HttpMessageNotReadable
	// will come
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Request Body is send empty and  not supported");
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}

	// the client is support to call rest api using get method but called using post
	// method then HttpRequestMethodNotSupported exception is thrown
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Request Metod Type not supported");
		list.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}

	// if the client give wrong path variable then MissingPathVariable exception is
	// thrown
	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Path Variable is missing");
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}

	// if the request param is missing then MissingServletRequestParameter will be
	// thrown
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Request Parameter missing");
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}

//if the client is supposed to give integer value but gave string
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Type Mismatched");
		ApiErrors errors = new ApiErrors(message, list, status, LocalDateTime.now());
		return ResponseEntity.status(status).body(errors);
	}
//--------------------------------------------------------------------------
	//this is our custom exception
	@ExceptionHandler(BookNotFoundException.class)
	protected ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException ex) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("Book Not Found Exception");
		ApiErrors errors = new ApiErrors(message, list, HttpStatus.BAD_REQUEST, LocalDateTime.now());//here the message need to come from impl class that is  throw new BookNotFoundException("Book with the Author :"+author+" not found");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	@ExceptionHandler(IdNotFoundException.class)
	protected ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException ex) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("The following Book Id not found in our database");
		ApiErrors errors = new ApiErrors(message, list, HttpStatus.NOT_FOUND, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
//---------------------------------------there might be some other exception which may occur like null pointer,sql u cannot write exception handler for each n every exception.Let create fall back handler to handle all other exception

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOtherException(Exception ex) {
		String message = ex.getMessage();
		List<String> list = new ArrayList();
		list.add("other exception");
		list.add(ex.getMessage());
		ApiErrors errors = new ApiErrors(message, list, HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

}

//http://localhost:8080/book/bookbyauthor?autho1r=Vishal --handleMissingServletRequestParameter
