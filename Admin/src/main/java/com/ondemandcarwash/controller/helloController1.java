package com.ondemandcarwash.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class helloController1 {
	public String sayHello() {
		return "Hello, from ADMIN";
		
	}

}
