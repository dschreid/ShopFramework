package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.exception.PasswordMismatchException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.service.SessionService;
import com.github.dschreid.shop.server.api.AuthApi;
import com.github.dschreid.shop.server.dto.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {
    private final SessionService service;

    @Autowired
    public AuthController(SessionService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<AuthResponse> login(LoginRequest loginDTO) throws UserNotFoundException, PasswordMismatchException {
        return ResponseEntity.ok(service.login(loginDTO));
    }

    @Override
    public ResponseEntity<Boolean> logout(String token) throws UnauthorizedAccessException {
        return ResponseEntity.ok(service.logout(token));
    }

}
