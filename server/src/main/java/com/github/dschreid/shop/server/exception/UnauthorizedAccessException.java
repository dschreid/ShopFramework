package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Unauthorized access exception.
 *
 * @author dschreid
 */
public class UnauthorizedAccessException extends ThrowableResponseException {
    /**
     * Instantiates a new Unauthorized access exception.
     */
    public UnauthorizedAccessException() {
        super(HttpStatus.UNAUTHORIZED, "Unauthorized");
    }
}
