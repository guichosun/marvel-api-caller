package org.globant.challenge.openpay.apicaller.service;

import org.globant.challenge.openpay.apicaller.commons.MarvelCharacter;

import java.util.List;

/**
 * Operation for interact from external Marvel API
 *
 * @author luis.delcampo
 */
public interface CharacterMarvelService {

    /**
     * Retrieve one {@link MarvelCharacter} by id.
     *
     * @param id The id of {@link MarvelCharacter}.
     *
     * @return The unique {@link MarvelCharacter} for the id.
     */
    MarvelCharacter getCharacterById(Long id);

    /**
     * Retrieve all {@link MarvelCharacter} from external API.
     *
     * @return A List of {@link MarvelCharacter}.
     */
    List<MarvelCharacter> getAllCharacter();

}
