High Availability Eureka Server
--------------------------------
Need to create two profiles for each Eureka server
For example, lets say
1. Eureka Instance One - eurekainstance1
2. Eureka Instance Two - eurekainstance2

Gives information about eurekainstance1 to eurekainstance2 and vice versa.

We have to put host entries for these eureka instance names.

------------------------------------------------------------------------------------------------------

for each profile we created .properties files 
like application-eurekainstance1.properties and application-eurekainstance2.properties

while running eureka instance 1
-------------------------------
we need to go for 'run configuration' and give 
--spring.profiles.active=eurekainstance1

while running eureka instance 2
-------------------------------
we need to go for 'run configuration' and give 
--spring.profiles.active=eurekainstance2
