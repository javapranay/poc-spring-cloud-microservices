package com.st.spring.cloud.demo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceOneRibbionClientService {
	
	private final RestTemplate restTemplate;
	
	@Autowired
    public ServiceOneRibbionClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
	
    @CircuitBreaker(name = "service-one", fallbackMethod = "serviceOneSayHelloFallback")
    public String invokeSayHello() {
    	String serviceAURl = "http://service-one/hello";
		ResponseEntity<String> response = restTemplate
				.exchange(serviceAURl, HttpMethod.GET, null, String.class);
    	System.out.println("--------------inside invokeSayHello--------------");
        return response.getBody();
    }

    public String serviceOneSayHelloFallback(Throwable t) {
        System.err.println("********* Invoking Resilience4J fallback method *********");
        return "Hello! This response is from Resilience4J fallback method, because service-one is unavailable...";
    }
    
}
