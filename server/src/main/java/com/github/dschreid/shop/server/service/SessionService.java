package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.LoginRequest;
import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.exception.PasswordMismatchException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.model.Role;
import com.github.dschreid.shop.server.model.Session;
import com.github.dschreid.shop.server.model.User;

import java.util.Optional;

/**
 * Contains Methods to interact with sessions and authentication
 *
 * @author dschreid
 */
public interface SessionService {
    /**
     * Login auth response.
     *
     * @param loginDTO the login dto
     * @return the auth response
     * @throws UserNotFoundException     the user not found exception
     * @throws PasswordMismatchException the password mismatch exception
     */
    AuthResponse login(LoginRequest loginDTO) throws UserNotFoundException, PasswordMismatchException;
    /**
     * Authenticate user.
     *
     * @param sessionToken the session token
     * @return the user
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    User authenticate(String sessionToken) throws UnauthorizedAccessException;
    /**
     * Logout a user by it's session token.
     *
     * @param sessionToken the session token
     * @return the boolean
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    boolean logout(String sessionToken) throws UnauthorizedAccessException;
    /**
     * Authorize user.
     *
     * @param sessionToken the session token
     * @return the associated user
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    User authorize(String sessionToken) throws UnauthorizedAccessException;
    /**
     * Authorize user.
     *
     * @param sessionToken the session token
     * @param minLevel     the min level
     * @return the user
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    User authorize(String sessionToken, Role minLevel) throws UnauthorizedAccessException;
    /**
     * Find a session by a token.
     *
     * @param token token
     * @return the session
     */
    Optional<Session> getSession(String token);
    /**
     * Authorize user.
     *
     * @param user     the user
     * @param minLevel the min level
     * @return the user
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    User authorize(User user, Role minLevel) throws UnauthorizedAccessException;
    /**
     * Create a new session for a user.
     *
     * @param user the user
     * @return the auth response
     */
    AuthResponse createSession(User user);
}
