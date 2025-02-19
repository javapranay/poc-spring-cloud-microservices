1: The first situation is whether the imported package does not match

If you used @EnableDiscoveryClient

	import org.springframework.cloud.client.discovery.DiscoveryClient "instead of " com.netflix.discovery.DiscoveryClient

If you used @EnableEurekaClient use this below import

	import org.springframework.cloud.netflix.eureka.EnableEurekaClient 

2: I did not select the starer-web dependency when I created the module, have added this below dependency in pom.xml and rebuild the project to fetch the added dependency.

	<dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-web</artifactId>
	</dependency>