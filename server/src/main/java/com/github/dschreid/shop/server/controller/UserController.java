package com.github.dschreid.shop.server.controller;

import com.github.dschreid.shop.server.dto.request.AddBalanceRequest;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserAlreadyExistsException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.service.SessionService;
import com.github.dschreid.shop.server.service.UserService;
import com.github.dschreid.shop.server.api.UserApi;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.model.Role;
import com.github.dschreid.shop.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController implements UserApi {
    private final SessionService sessionService;
    private final UserService userService;

    @Autowired
    public UserController(SessionService sessionService, UserService userService) {
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public ResponseEntity<User> getUser(String sessionToken, String user) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.ADMIN);
        final Optional<User> userByLogin = userService.findUserByUsername(user);
        return userByLogin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<User>> getUsers(String sessionToken) throws UnauthorizedAccessException {
        sessionService.authorize(sessionToken, Role.ADMIN);
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<Boolean> register(RegisterRequest register) throws UserAlreadyExistsException {
        userService.register(register);
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> addBalance(String sessionToken, AddBalanceRequest request) throws UnauthorizedAccessException, UserNotFoundException {
        final User admin = sessionService.authorize(sessionToken, Role.ADMIN);
        final User user = userService.findUserByUsername(request.getUsername()).orElseThrow(UserNotFoundException::new);
        userService.addBalance(user, request.getAmount());
        return ResponseEntity.ok(true);
    }

}
