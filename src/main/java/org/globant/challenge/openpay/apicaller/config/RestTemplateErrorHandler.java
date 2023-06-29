package org.globant.challenge.openpay.apicaller.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

/**
 * For manage the errors to RestTemplate.
 *
 * @author luis.delcampo
 */
@Component
@Slf4j
public class RestTemplateErrorHandler implements ResponseErrorHandler {


    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        log.info("An Error {}",response.getStatusCode());

        // Only trye with
        return true;
    }


    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        log.info("An Error httpResponse {}",httpResponse.getStatusCode());

        // TODO Add more error code

        if (httpResponse.getStatusCode().series() == CLIENT_ERROR) {

            // if not_found the Character
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new AppException("Not found", HttpStatus.NOT_FOUND.value());
            }
        }
    }
}