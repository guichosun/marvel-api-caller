package org.globant.challenge.openpay.apicaller.service;

import org.globant.challenge.openpay.apicaller.commons.MarvelCharacter;
/**
 * Operation for interact whit external Marvel API
 *
 * @author luis.delcampo
 */
public interface CharacterMarvelService {

    /**
     * Retrieve one {@link MarvelCharacter} by id.
     *
     * @param id The id of {@link MarvelCharacter}
     *
     * @return The unique {@link MarvelCharacter} for the id
     */
    MarvelCharacter getCharacterById(Long id);

    /**
     *
     * @return
     */
    List<MarvelCharacter> getAllCharacter();

}
