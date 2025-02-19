Here we are not dealing with service instances directly. 
So I do not have to worry about whether producer service has one service instance or multiple service instances.
I just need to create a url by keeping "service-name/api-url" and pass it to RestTemplate.
RestTemplate will pass this url to Ribbon.
Ribbon takes service-name, goes to DiscoveryClient.
DiscoveryClient will fetch list of ip-addresses of service instances corresponding producer service.
From these list of ip-addresses Ribbon will do load balancing.