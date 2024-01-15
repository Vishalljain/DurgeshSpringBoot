package com.infybuzz.cloud.Exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrors {
	String message;
	List<String> details;
	HttpStatus httpStatus;
	LocalDateTime timeStamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ApiErrors(String message, List<String> details, HttpStatus httpStatus, LocalDateTime timeStamp) {
		super();
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
	}
	public ApiErrors() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ApiErrors [message=" + message + ", details=" + details + ", httpStatus=" + httpStatus + ", timeStamp="
				+ timeStamp + "]";
	}
	

}
