package com.example.demo.prop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class EncryptedConfigPropertiesHolder {
	
	@Value("${my.encrypted.prop}")
	private String encryptedProp;

	public String getEncryptedProp() {
		return encryptedProp;
	}

	public void setEncryptedProp(String encryptedProp) {
		this.encryptedProp = encryptedProp;
	}

	@Override
	public String toString() {
		return "EncryptedConfigPropertiesHolder [encryptedProp=" + encryptedProp + "]";
	}

}
