package com.rest.min.filteringdynamic;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.min.filteringstatic.Somebean;

@RestController
public class DynamicFilteringController {
	//field1,field2
	@GetMapping("/dynamicfiltering")
	public MappingJacksonValue retrieveSomeBeandynamically() {
		SomeBean1 someBean1 = new SomeBean1("value1","value2","value3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeFileterName",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean1);
		mapping.setFilters(filters);
		return mapping;
	}
	@GetMapping("/listdynamicfiltering")
	public MappingJacksonValue retrieveSomeBeandynamicallyList() {
		List<SomeBean1> asList = Arrays.asList(new SomeBean1("value1","value2","value3"),new SomeBean1("value10","value20","value30"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("filed1","filed3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("SomeFileterName",filter);
		MappingJacksonValue mapping = new MappingJacksonValue(asList);
		mapping.setFilters(filters);
		return mapping;
	}
	
	


}
