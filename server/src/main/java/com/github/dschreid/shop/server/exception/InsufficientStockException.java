package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Insufficient stock exception.
 *
 * @author dschreid
 */
public class InsufficientStockException extends ThrowableResponseException {
    /**
     * Instantiates a new Insufficient stock exception.
     */
    public InsufficientStockException() {
        super(HttpStatus.FORBIDDEN, "Insufficient Stock");
    }
}
