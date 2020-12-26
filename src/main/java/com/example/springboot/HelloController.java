package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

("/rest")
@RestController
public class HelloController {

	@RequestMapping("/get")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
