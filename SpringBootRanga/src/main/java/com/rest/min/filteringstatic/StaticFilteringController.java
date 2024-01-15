package com.rest.min.filteringstatic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {
	@GetMapping("/filtering")
	public Somebean retrieveSomeBean() {
		return new Somebean("valu1","value2","value3");
	}

	@GetMapping("/list-filtering")
	public List<Somebean> retrieveSomeBeanList() {
		return Arrays.asList(new Somebean("value1","value2","value3"),new Somebean("value10","value20","value30"));
	}

}
