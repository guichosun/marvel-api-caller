package org.globant.challenge.openpay.apicaller;

import org.globant.challenge.openpay.apicaller.config.RestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
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

	/**
	 * To configure the RestTemplate bean.
	 * - Adding an Error handler.
	 */
	@Bean("clientRest")
	public RestTemplate configRestTemplate(RestTemplateBuilder restTemplateBuilder) {

		// Basic configuration with error handler
		return restTemplateBuilder
				.errorHandler(new RestTemplateErrorHandler())
				.build();
	}
	
}