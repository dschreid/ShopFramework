package com.github.dschreid.shop.server.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Model for Throwable response exception.
 *
 * @author dschreid
 */
@Getter
public class ThrowableResponseException extends Throwable {
    private final HttpStatus status;
    private final String reason;

    /**
     * Instantiates a new Throwable response exception.
     *
     * @param status the status
     * @param reason the reason
     */
    public ThrowableResponseException(HttpStatus status, String reason) {
        this.status = status;
        this.reason = reason;
    }
}
