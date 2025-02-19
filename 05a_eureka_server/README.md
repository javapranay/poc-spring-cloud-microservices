Operations of a service registry (eureka server)

1. A service instance gets registered themselves to the eureka server automatically when they start.
2. A client which needs an instance of a service, gets the instance from the eureka server (client side load balancing can be used)
3. Highly available eureka service, multiple peer to peer instances of eureka service should be running each storing the service registry information. If one goes down other instance should be available to serve the service lookup requests.
4. Monitor service instances health and the service instance should be automatically removed from the eureka server. For health monitoring, the service instances (which will be having the eureka client running in them) should keep sending heart beat to the eureka server. The heart beat interval is every 10secs. If any service instance stops sending heart beat, eureka server will automatically remote it from the registry to make sure that no requests will go to that service instance.

Configurations required to be done

1. server.port=8761
2. eureka.client.register-with-eureka=false 
	* no need to register eureka server with itself
3. eureka.client.fetch-registry=false
	* do not cache the service registry locally, the server instances registration and removal should happen as and when they are available or goes down.
	  But for client application this should be set to true. Because clients should not go to eureka server everytime it needs a service instance, 
	  instead it should cache locally and only refresh the list of instances time to time from eureka server. 
4. eureka.server.wait-time-in-ms-when-sync-empty=5
	* eureka server wont publish the service instances immediately, it will wait for 3 heart beats from the service instance, each hearbeat would be after 10sec, 
	  so before a service instance can be published by eureka server it takes 30secs
5. eureka.server.enable-self-preservation=false
	* if suddenly many instances of a service stops sending the hearbeat, then eureka server thinks that there is a network problem 
	  and it wont de-register the services even though they are not responding. This set up may be good in production where there are many instances running
	  but in local machine if you are running one instance and want to test de-registration, it wont work if this property is set to true
 
To see the details of an instance registered to the eureka server we can use the URL pattern 
	`http://localhost:8761/eureka/apps/<instance-name>`
	`http://localhost:8761/eureka/apps/service-a`