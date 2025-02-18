Decrypting property values on the client side
---------------------------------------------
1. Add the same symmetric key in bootstrap.properties
		encrypt.key=myencryptionkey
2. Add the dependency
		<dependency>
   			<groupId>org.springframework.security</groupId>
   			<artifactId>spring-security-rsa</artifactId>
		</dependency>