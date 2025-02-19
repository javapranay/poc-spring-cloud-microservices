package com.st.spring.cloud.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("service-one")
public interface ServiceOneFeignClient {
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String invokeServiceOne();

//	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
//	String helloWithName(@PathVariable("name") String name);
	
}
