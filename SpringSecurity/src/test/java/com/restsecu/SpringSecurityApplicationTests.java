package com.restsecu;

import org.junit.jupiter.api.Test; 
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityApplicationTests {

	@Test
	void test() {
		System.out.println(new BCryptPasswordEncoder().encode("john"));//doug
		//System.out.println(new Pbkdf2PasswordEncoder().encode("vishal"));
		//System.out.println(new SCryptPasswordEncoder( ).encode("vishal"));//we need to add dependency in pom.xml 
		
	}

}
