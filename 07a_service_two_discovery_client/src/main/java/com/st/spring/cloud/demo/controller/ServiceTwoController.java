package com.st.spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.cloud.demo.client.ServiceOneDiscoveryClient;

@RestController
public class ServiceTwoController {
	
	private final ServiceOneDiscoveryClient discoveryClient;
	
	@Autowired
	public ServiceTwoController(final ServiceOneDiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}

	@RequestMapping(path = "/discoveryclient/test", method = RequestMethod.GET)
	public String discoveryClientTest() {
		final String serviceOneResp = discoveryClient.invokeServiceOne();
		return "Service one response is ===>" + serviceOneResp;
	}
	
	
	
	
	
	
	
	
}
