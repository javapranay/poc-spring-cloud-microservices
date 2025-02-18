package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.prop.EncryptedConfigPropertiesHolder;

@RestController
public class EncryptedConfigRestController {
	
	
	private EncryptedConfigPropertiesHolder propertiesHolder;
	
	@Autowired
	public EncryptedConfigRestController(EncryptedConfigPropertiesHolder propertiesHolder) {
		this.propertiesHolder = propertiesHolder;
	}

	@GetMapping("/encryptedconfigserver/test")
	public String getConfigs() {
		return propertiesHolder.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
