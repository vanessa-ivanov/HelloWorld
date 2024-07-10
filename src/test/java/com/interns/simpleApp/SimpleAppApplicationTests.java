package com.interns.simpleApp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootTest
class SimpleAppApplicationTests {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/register")
	public String userRegistration(@ModelAttribute VehicleTests vehicleTests) {
		System.out.println(vehicleTests.toString());
		return "index";
	}

}
