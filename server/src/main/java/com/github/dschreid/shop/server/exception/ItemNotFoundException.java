package com.github.dschreid.shop.server.exception;

import org.springframework.http.HttpStatus;

/**
 * Model for Item not found exception.
 *
 * @author dschreid
 */
public class ItemNotFoundException extends ThrowableResponseException {
    /**
     * Instantiates a new Item not found exception.
     */
    public ItemNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Item Not Found");
    }
}
