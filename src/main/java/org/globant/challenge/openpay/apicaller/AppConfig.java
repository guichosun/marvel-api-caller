package org.globant.challenge.openpay.apicaller;

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

		// Basic configuration
		return new RestTemplate();
	}
	
}