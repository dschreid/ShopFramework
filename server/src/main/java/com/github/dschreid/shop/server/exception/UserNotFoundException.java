package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for User not found exception.
 *
 * @author dschreid
 */
public class UserNotFoundException extends ThrowableResponseException {
    /**
     * Instantiates a new User not found exception.
     */
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "User Not Found");
    }
}
