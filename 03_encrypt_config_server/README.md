Encrypted properties
---------------------
1. Set up a symmetric key in bootstrap.properties
		encrypt.key=myencryptionkey
2. To encrypt any value use /encrypt API
		http://localhost:9090/encrypt
   Take the output of this API call and put it as the property value.
   All the encrypted properties values we should prefix {cipher}
3. Spring cloud server will automatically decrypt the value while returning.
		http://localhost:9090/encryption-config-server/default
		
Return properties without decrypting them
-----------------------------------------
1. Set the encrypt enable property to false in bootstrap.properties
		spring.cloud.config.server.encrypt.enabled=false
2. In this case the value will be returned in encrypted format to the config clients

	http://127.0.0.1:9090/encryption-config-client/dev
	
	http://127.0.0.1:9090/encryption-config-client.properties