package org.globant.challenge.openpay.apicaller.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Represents a Character data container.
 *
 * @author luis.delcampo
 */
@Getter
@Setter
public class CharacterDataContainer {

    /**
     * The requested offset (number of skipped results) of the call.
     */
    private Integer offset;

    /**
     * The requested result limit.
     */
    private Integer limit;

    /**
     * The total number of resources available given the current filter set.
     */
    private Integer total;

    /**
     * The total number of results returned by this call.
     */
    private Integer count;

    /**
     * The list of characters returned by the call.
     */
    private List<Character> results;
}
