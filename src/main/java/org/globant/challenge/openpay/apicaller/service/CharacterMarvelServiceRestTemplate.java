package org.globant.challenge.openpay.apicaller.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.commons.MarvelCharacter;
import org.globant.challenge.openpay.apicaller.commons.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation using RestTemplate in order to
 * make call to the marvel API.
 *
 * @author luis.delcampo
 */
@Service
@Slf4j
@AllArgsConstructor
public class CharacterMarvelServiceRestTemplate implements CharacterMarvelService {

    /**
     * RestTemplate to perform http calls.
     */
    private RestTemplate clientRest;

    /**
     * The PropertySource.
     */
    private final PropertySource propertySource;

    /**
     * @see CharacterMarvelService#getCharacterById(Long)
     */
    @Override
    public MarvelCharacter getCharacterById(Long id) {
        String url = propertySource.getUrlBase()+propertySource.getApiCharacters();

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        // Making the call to marvel api
        // TODO Manage RestClientException in ControllerAdvice

        return clientRest.getForObject(
                url+"/{id}", MarvelCharacter.class, pathVariables);

    }

    /**
     * @see CharacterMarvelService#getAllCharacter()
     */
    @Override
    public List<MarvelCharacter> getAllCharacter() {

        String url = propertySource.getUrlBase()+propertySource.getApiCharacters();

        // TODO Manage RestClientException in ControllerAdvice
        return Arrays.asList(
                clientRest.getForObject(url, MarvelCharacter[].class));

    }
}
