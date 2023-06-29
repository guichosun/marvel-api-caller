package org.globant.challenge.openpay.apicaller.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.model.response.Character;
import org.globant.challenge.openpay.apicaller.model.response.CharacterDataContainer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     *
     */
    private DataFacade facade;

    /**
     * @see CharacterMarvelService#getCharacterById(String)
     */
    @Override
    public Optional<Character> getCharacterById(String id) {

        log.info("stuff for retrieve a Char");
        // Only return the first element
        CharacterDataContainer cdc = facade.retrieveCharacterById(id);
        return Optional.ofNullable(cdc.getResults().get(0));
    }

    /**
     * @see CharacterMarvelService#getAllCharacter()
     */
    @Override
    public List<Character> getAllCharacter() {
        log.debug("Only necessary stuff for business");

        // Getting Character list
        return facade.retrieveAllCharacter().getResults();

    }
}
