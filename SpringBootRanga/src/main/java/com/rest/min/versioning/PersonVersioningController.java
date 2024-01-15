package com.rest.min.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	//called as uri versioning
	@GetMapping("v1/person")
	public Personv1 personv1() {
		return new Personv1("bob charlie");
	}
	@GetMapping("v2/person")
	public Personv2 personv2() {
		return new Personv2(new Name("bob", "charlie"));
	}
	//called asrequest parameter versioning
		@GetMapping(value = "person/param", params="version=1")
		public Personv1 paramv1() {
			return new Personv1("bob charlie");
		}
		@GetMapping(value ="person/param", params="version=2")
		public Personv2 paramv2() {
			return new Personv2(new Name("bob", "charlie"));
		}
		//called as header versioning
		@GetMapping(value = "person/headerhi", headers="X_API_VERSION=1")
		public Personv1 headerv1() {
			return new Personv1("bob charlie");
		}
		@GetMapping(value = "person/headerhi", headers="X_API_VERSION=2")
		public Personv2 headerv2() {
			return new Personv2(new Name("bob", "charlie"));
		}
		//call as media versioning or mime type versioning
		@GetMapping(value = "person/produces", produces="application/vnd.company.app-v1+json")
		public Personv1 producesv1() {
			return new Personv1("bob charlie");
		}
		@GetMapping(value = "person/produces", produces="application/vnd.company.app-v2+json")
		public Personv2 producesv2() {
			return new Personv2(new Name("bob", "charlie"));
		}

}
