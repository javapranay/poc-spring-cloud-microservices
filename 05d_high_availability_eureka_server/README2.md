*Have to do two things*

1)Edit C:\Windows\System32\drivers\etc\hosts file:
--------------------------------------------------
	127.0.0.1       eurekainstance1
	127.0.0.1       eurekainstance2
	127.0.0.1       eurekainstance3

	Edit hosts file if you are trying this on a single system(I am currently running locally in preparation for a deployment) so that the values in eureka.client.serviceUrl.defaultZone have different host names. We should not use localhost, or the same ip or dns name for replicated Eureka instances.

	
#2)Make sure the values of eureka.instance.hostname should be same as hostnames we mentioned in hosts file.

Base properties:
----------------
	eureka.client.register-with-eureka=true
	eureka.client.fetch-registry=true
	eureka.instance.appName=ServiceRegistryCluster
	eureka.environment=local

peer1 profile properties:
-------------------------
	spring.application.name=spring-cloud-eureka-server
	eureka.instance.hostname=eurekainstance1
	server.port=8761
	eureka.client.serviceUrl.defaultZone=http://eurekainstance2:8762/eureka/,http://eurekainstance3:8761/eureka/

peer2 profile properties:
-------------------------
	spring.application.name=spring-cloud-eureka-server
	eureka.instance.hostname=eurekainstance2
	server.port=8762
	eureka.client.serviceUrl.defaultZone=http://eurekainstance1:8761/eureka/,http://eurekainstance3:8763/eureka/
	
peer3 profile properties:
-------------------------
	spring.application.name=spring-cloud-eureka-server
	eureka.instance.hostname=eurekainstance3
	server.port=8763
	eureka.client.serviceUrl.defaultZone=http://eurekainstance1:8761/eureka/,http://eurekainstance2:8762/eureka/
	
	
`Now when I look at the Eureka console for eurekainstance1, I can see eurekainstance2 & eurekainstance3 listed as an available replica, and vice-versa for the eurekainstance2 & eurekainstance3 console.`

# package jar file
	mvn clean package
# start eureka server using 3 configurations
	java -jar 05d_high_availability_eureka_server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eurekainstance1
	java -jar 05d_high_availability_eureka_server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eurekainstance2
	java -jar 05d_high_availability_eureka_server-0.0.1-SNAPSHOT.jar --spring.profiles.active=eurekainstance3