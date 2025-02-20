# application.properties

> resilience4j.circuitbreaker.instances.service-one.registerHealthIndicator: true
> 
> resilience4j.circuitbreaker.instances.service-one.failureRateThreshold: 50
> 
> resilience4j.circuitbreaker.instances.service-one.waitDurationInOpenState: 5000
> 
> resilience4j.circuitbreaker.instances.service-one.ringBufferSizeInClosedState: 10
> 
> resilience4j.circuitbreaker.instances.service-one.ringBufferSizeInHalfOpenState: 5
> 
> resilience4j.circuitbreaker.instances.service-one.slidingWindowType: COUNT_BASED
> 
> resilience4j.circuitbreaker.instances.service-one.slidingWindowSize: 10
> 

# test url

http://192.168.56.1:9097/resilience4j/test