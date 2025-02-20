package com.st.spring.cloud.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOneController {

	@RequestMapping(path = "/hello")
	public String sayHello() {
		System.out.println("********* Invoking desired method *********");
		return "Hello..! from service one (response from actual backend service)";
	}
}
