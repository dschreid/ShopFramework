package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for User already exists exception.
 *
 * @author dschreid
 */
public class UserAlreadyExistsException extends ThrowableResponseException {
    /**
     * Instantiates a new User already exists exception.
     */
    public UserAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "User Already Exists");
    }
}
