package com.github.dschreid.shop.server.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This interface is used to test connection and availability.
 *
 * @author dschreid
 */
@RequestMapping("/services/ping")
public interface PingApi {
    @GetMapping
    ResponseEntity<Boolean> ping();
}
