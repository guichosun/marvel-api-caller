package org.globant.challenge.openpay.apicaller.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicaller.model.response.Character;
import org.globant.challenge.openpay.apicaller.service.CharacterMarvelService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class MarvelCharacterController {

    private final CharacterMarvelService service;

    /**
     * API for Retrieve all Marvel Characters.
     *
     * @return A {@link ResponseEntity} with all {@link Character}
     */
    @GetMapping()
    public ResponseEntity<List<Character>> getCharacters() {
        log.debug("Retrieve all Marvel Characters");

        // TODO Making call to service
        List<Character> characters = service.getAllCharacter();

        // Exceptions are maneged br the advice

        return ResponseEntity.ok(characters);
    }

    /**
     * To obtain a character by id.
     *
     * @param id the Character's id
     * @return A single {@link Character}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable String id) {
        log.info("The character id {}", id);

        // Exceptions are maneged br the advice
        // Get a Character
        return ResponseEntity.ok(service.getCharacterById(id).orElseThrow());
    }

}
