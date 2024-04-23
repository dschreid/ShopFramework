package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Order not found exception.
 *
 * @author dschreid
 */
public class OrderNotFoundException extends ThrowableResponseException {
    /**
     * Instantiates a new Order not found exception.
     */
    public OrderNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Order Not Found");
    }
}
