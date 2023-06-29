package org.globant.challenge.openpay.apicaller.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.PropertySource;
import org.globant.challenge.openpay.apicaller.model.response.CharacterDataContainer;
import org.globant.challenge.openpay.apicaller.model.response.CharacterDataWrapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * The Facade component in order to
 * reduce the service complex.
 * It interacts with all RestTemplate interactions.
 *
 * @author luis.delcampo
 */
@Component
@AllArgsConstructor
@Slf4j
public class DataFacade {

    /**
     * RestTemplate to perform http calls.
     */
    private RestTemplate clientRest;

    /**
     * The PropertySource.
     */
    private final PropertySource propertySource;

    /**
     * Retrieve a {@link CharacterDataContainer}
     * @param id An identifier.
     * @return An instance of {@link CharacterDataContainer}
     */
    public CharacterDataContainer retrieveCharacterById(String id) {

        // Build url with req parameters
        String url = propertySource.getUrlBase()+propertySource.getApiCharacters()+"/{id}";

        String urlTemplate = uriBuilder(url);

        log.info("The URL with params {}",urlTemplate);

        // Build parameters
        Map<String, String> params = paramsBuilder();
        params.put("id", id);

        log.info("The parameters {}",params);

        // Making the call to marvel api
        // TODO Manage RestClientException in ControllerAdvice

        ResponseEntity<CharacterDataWrapper> response = clientRest.exchange(
                urlTemplate, HttpMethod.GET, null,
                CharacterDataWrapper.class, params);


        log.debug("The status code for call {}",response.getStatusCode());

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error on call api "
                    +response.getStatusCode());
        }
        return response.getBody().getData();

    }

    /**
     * Retrieve all characters from a call to api external.
     * Using RestTemplate client.
     *
     * @return A {@link CharacterDataContainer} instance.
     */
    public CharacterDataContainer retrieveAllCharacter() {

        // Build url with req parameters
        String urlTemplate = uriBuilder(propertySource.getUrlBase()+propertySource.getApiCharacters());

        log.debug("The URL with params {}",urlTemplate);

        // Build parameters
        Map<String, String> params = paramsBuilder();

        log.debug("The parameters {}",params);

        // TODO Manage RestClientException in ControllerAdvice
        ResponseEntity<CharacterDataWrapper> response = clientRest.exchange(
                urlTemplate, HttpMethod.GET, null,
                CharacterDataWrapper.class, params);

        log.debug("The status code for call {}",response.getStatusCode());

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error on call api "
                    +response.getStatusCode());
        }
        return response.getBody().getData();
    }

    /*
     * Builder method for the url.
     */
    private String uriBuilder(String url) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("ts", "{ts}")
                .queryParam("apikey", "{apikey}")
                .queryParam("hash", "{hash}")
                .encode()
                .toUriString();
    }

    /*
     * Build the request parameters
     */
    private Map<String, String> paramsBuilder() {

        Map<String, String> params = new HashMap<>();
        params.put("ts",propertySource.getTimestamp());
        params.put("apikey", propertySource.getApikey());
        params.put("hash", propertySource.getHash());

        log.debug("The parameters {}",params);

        return params;
    }

}
