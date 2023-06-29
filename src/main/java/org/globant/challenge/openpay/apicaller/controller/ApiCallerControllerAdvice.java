package org.globant.challenge.openpay.apicaller.controller;

import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.config.AppException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Configuration class in order to config the RestTemplate.
 *
 * @author luis.delcampo
 */
@Slf4j
@RestControllerAdvice
public class ApiCallerControllerAdvice extends ResponseEntityExceptionHandler {
	// TODO I need to implement several methods

    @ExceptionHandler({AppException.class})
    public ResponseEntity<String> handleException(AppException exception) {
      log.info("An exception occurs {}",exception.getMessage());
      return ResponseEntity.status(exception.getCode())
              .body(exception.getMessage());
    }
}