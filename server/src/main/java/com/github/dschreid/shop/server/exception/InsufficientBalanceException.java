package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Insufficient balance exception.
 *
 * @author dschreid
 */
public class InsufficientBalanceException extends ThrowableResponseException {
    /**
     * Instantiates a new Insufficient balance exception.
     */
    public InsufficientBalanceException() {
        super(HttpStatus.FORBIDDEN, "Insufficient Balance");
    }
}
