package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.api.PingApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController implements PingApi {
    @Override
    public ResponseEntity<Boolean> ping() {
        return ResponseEntity.ok(true);
    }
}
