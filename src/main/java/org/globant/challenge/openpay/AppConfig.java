package org.globant.challenge.openpay;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class in order to config the RestTemplate.
 *
 * @author luis.delcampo
 */
@Configuration
public class AppConfig {

	@Bean("clientRest")
	public RestTemplate configRestTemplate() {
		return new RestTemplate();
	}
	
}