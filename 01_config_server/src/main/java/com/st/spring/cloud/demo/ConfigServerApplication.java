package com.st.spring.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer		//To make this Application as a config server
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
	
/**
* After adding spring-cloud-config-server and annotating this class with @EnableConfigServer
* this application starts behaving like config server. That means it automatically expose some api's
* which config client will use to obtain configuration properties.
*/
	

	
}
