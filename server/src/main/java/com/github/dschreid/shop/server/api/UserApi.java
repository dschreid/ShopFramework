package com.github.dschreid.shop.server.api;

import com.github.dschreid.shop.server.dto.request.AddBalanceRequest;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserAlreadyExistsException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The interface User api.
 *
 * @author dschreid
 */
@RequestMapping("/services/user")
public interface UserApi {

    /**
     * Gets user by its username
     *
     * @param sessionToken the session token
     * @param user         the user you would like to find
     * @return information about the user
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    @GetMapping("/get/{user}")
    ResponseEntity<User> getUser(@RequestHeader("session-token") String sessionToken, @PathVariable String user) throws UnauthorizedAccessException;

    /**
     * Gets all users.
     *
     * @param sessionToken the session token
     * @return the users
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     */
    @GetMapping("/all")
    ResponseEntity<List<User>> getUsers(@RequestHeader("session-token") String sessionToken) throws UnauthorizedAccessException;

    /**
     * Register Attempt
     *
     * @param register Register DTO
     * @return response dto
     * @throws UserAlreadyExistsException the user already exists exception
     */
    @PostMapping("/register")
    ResponseEntity<Boolean> register(@Valid @RequestBody RegisterRequest register) throws UserAlreadyExistsException;

    /**
     * Add balance response entity.
     *
     * @param sessionToken the session token
     * @param request      the request
     * @return response dto
     * @throws UnauthorizedAccessException if the user was not logged in or not authorized to do this action
     * @throws UserNotFoundException       the user not found exception
     */
    @PostMapping("/balance/add")
    ResponseEntity<Boolean> addBalance(@RequestHeader("session-token") String sessionToken, @Valid @RequestBody AddBalanceRequest request) throws UnauthorizedAccessException, UserNotFoundException;

}
