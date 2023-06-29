package org.globant.challenge.openpay.apicaller.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Configuration class in order to config the RestTemplate.
 *
 * @author luis.delcampo
 */
@RestControllerAdvice
public class ApiCallerControllerAdvice extends ResponseEntityExceptionHandler {
	// TODO I need to implement several methods
	
}