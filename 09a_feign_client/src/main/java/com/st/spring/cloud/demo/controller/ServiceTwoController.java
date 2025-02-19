package com.st.spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.cloud.demo.client.ServiceOneFeignClient;

@RestController
public class ServiceTwoController {
	
	private final ServiceOneFeignClient feignClient;
	
	@Autowired
	public ServiceTwoController(final ServiceOneFeignClient feignClient) {
		this.feignClient = feignClient;
	}

	@RequestMapping(path = "/feign/test", method = RequestMethod.GET)
	public String feignTest() {
		return feignClient.invokeServiceOne();
	}
	
}
