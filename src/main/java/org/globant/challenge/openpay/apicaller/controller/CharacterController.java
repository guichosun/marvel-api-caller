package org.globant.challenge.openpay.apicaller.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.commons.MarvelCharacter;
import org.globant.challenge.openpay.apicaller.service.CharacterMarvelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController for the api-caller ms in order to
 * access to the external API.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "${api.base}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CharacterController {

    private final CharacterMarvelService service;

    /**
     * Regresar una list con todos los hoteles registrados
     */
    @GetMapping()
    public ResponseEntity<List<MarvelCharacter>> getCharacters() {
        log.info("Retrieve all Marvel Characters");

        // TODO Making call to service

        return ResponseEntity.noContent().build();
    }

    /**
     * To obtain a character by id.
     *
     * @param id the Character's id
     * @return A single {@link MarvelCharacter}
     */
    @GetMapping("/{id}")
    public ResponseEntity<MarvelCharacter> getCharacter(@PathVariable String id) {
        log.info("The character id {}", id);

        // Get a Character
        MarvelCharacter character = service.getCharacterById(Long.valueOf(id));
        return ResponseEntity.ok(character);
    }

}
