package com.infybuzz.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.infybuzz.cloud.Repository.StudentRepository;
import com.infybuzz.cloud.entity.Student;
import com.infybuzz.cloud.feign.AddressFeignClient;
import com.infybuzz.cloud.request.CreateStudentRequest;
import com.infybuzz.cloud.response.AddressResponse;
import com.infybuzz.cloud.response.StudentResponse;

import reactor.core.publisher.Mono;




@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	WebClient webClient;
	
	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);
	
		
		StudentResponse studentResponse = new StudentResponse(student);
		//For web client
	//	studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		//For feign
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		
		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		//for web client
	//	studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		
		return studentResponse;
	}
	 
	public AddressResponse getAddressById (long addressId) {
		Mono<AddressResponse> addressResponse = 
				webClient.get().uri("/getById/" + addressId)
		.retrieve().bodyToMono(AddressResponse.class);
		
		return addressResponse.block();
	}
}
