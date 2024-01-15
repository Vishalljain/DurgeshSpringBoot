package com.infybuzz.cloud;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class QuesterController {

	@Autowired
	private QuesterService foodQuesterService;

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> exception(ProductNotFoundException exception) {
		return new ResponseEntity<Object>("Product Not Found", HttpStatus.NOT_FOUND);
	}

	@GetMapping(value = "/quest/{qty}")
	public List<QuesterPojo> getAllItemList(@PathVariable int qty) throws ProductNotFoundException {
		return foodQuesterService.getAllItemList(qty);
	}
}
