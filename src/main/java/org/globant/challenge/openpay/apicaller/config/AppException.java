package org.globant.challenge.openpay.apicaller.config;

import lombok.Getter;
import lombok.Setter;

/**
 * Simple exception to handle app error.
 *
 * @author luis.delcampo
 */
@Getter
@Setter
public class AppException extends RuntimeException {

    /**
     * The error code.
     */
    private int code;

    public AppException(String message, int code) {
        super(message);
        this.code = code;
    }
}
