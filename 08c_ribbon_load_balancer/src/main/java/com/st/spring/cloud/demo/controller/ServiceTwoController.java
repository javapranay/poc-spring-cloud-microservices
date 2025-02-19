package com.st.spring.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.st.spring.cloud.demo.client.ServiceOneRibbonClient;

@RestController
public class ServiceTwoController {
	
	private final ServiceOneRibbonClient ribbonClient;
	
	@Autowired
	public ServiceTwoController(final ServiceOneRibbonClient ribbonClient) {
		this.ribbonClient = ribbonClient;
	}

	@RequestMapping(path = "/ribbon/test", method = RequestMethod.GET)
	public String ribbonTest() {
		return ribbonClient.invokeServiceOne();
	}
	
	
	
	
	
	
	
	
	
	
	
}
