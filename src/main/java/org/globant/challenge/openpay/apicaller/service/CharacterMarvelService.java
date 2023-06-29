package org.globant.challenge.openpay.apicaller.service;

import org.globant.challenge.openpay.apicaller.model.response.Character;

import java.util.List;
import java.util.Optional;

/**
 * Operation for interact from external Marvel API
 *
 * @author luis.delcampo
 */
public interface CharacterMarvelService {

    /**
     * Retrieve one {@link Character} by id.
     *
     * @param id The id of {@link Character}.
     *
     * @return The unique {@link Character} for the id.
     */
    Optional<Character> getCharacterById(String id);

    /**
     * Retrieve all {@link Character} from external API.
     *
     * @return A List of {@link Character}.
     */
    List<Character> getAllCharacter();

}
