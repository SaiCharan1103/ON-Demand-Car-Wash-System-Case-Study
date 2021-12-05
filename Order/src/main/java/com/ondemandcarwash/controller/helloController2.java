package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class helloController2 {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, from Order";
		
	}

}
