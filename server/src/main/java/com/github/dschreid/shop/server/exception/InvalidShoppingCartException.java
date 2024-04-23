package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Invalid shopping cart exception.
 *
 * @author dschreid
 */
public class InvalidShoppingCartException extends ThrowableResponseException {
    /**
     * Instantiates a new Invalid shopping cart exception.
     */
    public InvalidShoppingCartException() {
        super(HttpStatus.BAD_REQUEST, "Invalid Shopping Cart");
    }
}
