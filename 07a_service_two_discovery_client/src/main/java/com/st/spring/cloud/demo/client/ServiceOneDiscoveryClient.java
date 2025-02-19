package com.st.spring.cloud.demo.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServiceOneDiscoveryClient {
	
	// because of @EnableDiscoveryClient annotation I am able to autowire DiscoveryClient
	// otherwise this autowiring will get fail.
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public String invokeServiceOne() {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> instances = discoveryClient.getInstances("service-one");
		String serviceBaseUrl = instances.get(0).getUri().toString();
		System.out.println("serviceBaseUrl: " + serviceBaseUrl);
		String serviceAURl = serviceBaseUrl + "/serviceone/prop";
		
		ResponseEntity<String> response = restTemplate.exchange(serviceAURl, HttpMethod.GET, null, String.class);
		return response.getBody();
	}

	
	
	
	
	
	
	
	
	
	

}
