package org.globant.challenge.openpay.apicaller.service;

import org.globant.challenge.openpay.apicaller.model.response.Character;
import org.globant.challenge.openpay.apicaller.model.response.CharacterDataContainer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests for check service's behavioral.
 *
 * @author luis.delcampo
 */
@ExtendWith(MockitoExtension.class)
class CMSRestTemplateTest {

    @Mock
    DataFacade facade;

    @InjectMocks
    CharacterMarvelServiceRestTemplate serviceRestTemplate;

    /**
     * Given empty data, when call facade method, then verify results
     */
    @Test
    void retrieveAll_EmptyList() {

        // given mock data
        List<Character> empty = Collections.emptyList();
        CharacterDataContainer dataContainer = new CharacterDataContainer();
        dataContainer.setResults(Collections.emptyList());

        // when
        when(facade.retrieveAllCharacter()).thenReturn(dataContainer);

        List<Character> characters = serviceRestTemplate.getAllCharacter();

        // Then Verify
        verify(facade).retrieveAllCharacter();
        assertTrue(characters.isEmpty());
    }

    /**
     * Given valid data, when call facade method, then verify results
     */
    @Test
    void retrieveAll_ValidData() {

        // given mock data
        CharacterDataContainer dataContainer = new CharacterDataContainer();
        dataContainer.setResults(Arrays.asList(new Character()));

        // when
        when(facade.retrieveAllCharacter()).thenReturn(dataContainer);

        List<Character> characters = serviceRestTemplate.getAllCharacter();

        // Then Verify
        verify(facade).retrieveAllCharacter();
        assertTrue(!characters.isEmpty());
    }

}
