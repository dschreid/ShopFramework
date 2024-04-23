package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Password mismatch exception.
 *
 * @author dschreid
 */
public class PasswordMismatchException extends ThrowableResponseException {
    /**
     * Instantiates a new Password mismatch exception.
     */
    public PasswordMismatchException() {
        super(HttpStatus.UNAUTHORIZED, "Password Mismatch");
    }
}
