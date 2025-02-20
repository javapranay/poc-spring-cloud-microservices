package com.st.spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.cloud.demo.client.ServiceOneRibbionClientService;

@RestController
public class ServiceTwoController {
	
	private final ServiceOneRibbionClientService service;
	
	@Autowired
	public ServiceTwoController(final ServiceOneRibbionClientService service) {
		this.service = service;
	}

	@RequestMapping(path = "/resilience4j/test", method = RequestMethod.GET)
	
	public String feignTest() throws Exception {
		System.out.println("********* Invoking Service One *********");
		//Thread.sleep(5000);
		return service.invokeSayHello();
	}
	
}
