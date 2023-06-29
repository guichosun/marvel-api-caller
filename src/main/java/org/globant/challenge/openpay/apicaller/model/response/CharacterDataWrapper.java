package org.globant.challenge.openpay.apicaller.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Represents the character wrapper data that each call to the Marvel returns.
 *
 * @author luis.delcampo
 */
@Getter
@Setter
public class CharacterDataWrapper {

    /**
     * The HTTP status code of the returned result.
     */
    private int code;

    /**
     * A string description of the call status.
     */
    private String status;

    /**
     * A digest value of the content.
     */
    private String etag;

    /**
     * The copyright notice for the returned result.
     */
    private String copyright;

    /**
     * The attribution notice for this result.
     */
    private String attributionText;

    /**
     * An HTML representation of the attribution notice for this result.
     */
    private String attributionHTML;

    /**
     * A container	The results returned by the call.
     */
    private CharacterDataContainer data;
}
