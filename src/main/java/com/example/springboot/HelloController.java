package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class HelloController {

	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	@ResponseBody
	public String rest() {
		return "Greetings from Spring Boot!";
	}

}
