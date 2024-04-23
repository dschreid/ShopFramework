package com.github.dschreid.shop.server.api;

import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.exception.PasswordMismatchException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * The interface Auth api.
 *
 * @author dschreid
 */
@RequestMapping("/services/auth")
public interface AuthApi {

    /**
     * Login user by password.
     *
     * @param loginDTO the login dto
     * @return response dto
     * @throws UserNotFoundException     if the user does not exist
     * @throws PasswordMismatchException if the wrong password was input
     */
    @PostMapping("/login")
    ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginDTO) throws UserNotFoundException, PasswordMismatchException;

    /**
     * Logout user by token.
     *
     * @param token session token
     * @return true if the action has succeeded
     * @throws UnauthorizedAccessException if a wrong session token was input
     */
    @PostMapping("/logout")
    ResponseEntity<Boolean> logout(@RequestHeader("session-token") String token) throws UnauthorizedAccessException;
}
