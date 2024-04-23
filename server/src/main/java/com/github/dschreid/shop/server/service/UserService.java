package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.exception.InsufficientBalanceException;
import com.github.dschreid.shop.server.exception.UserAlreadyExistsException;
import com.github.dschreid.shop.server.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Contains Methods to interact with users
 *
 * @author dschreid
 */
public interface UserService {
    /**
     * Find a user by username.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findUserByUsername(String username);
    /**
     * Find a user by email.
     *
     * @param email the email
     * @return the optional
     */
    Optional<User> findUserByEmail(String email);
    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<User> getAllUsers();
    /**
     * Registers a user.
     *
     * @param register the register
     * @throws UserAlreadyExistsException the user already exists exception
     */
    void register(RegisterRequest register) throws UserAlreadyExistsException;
    /**
     * Add balance to a user.
     *
     * @param user   the user
     * @param amount the amount
     */
    void addBalance(User user, double amount);
    /**
     * Reduce balance to a user.
     *
     * @param user   the user
     * @param amount the amount
     * @throws InsufficientBalanceException the insufficient balance exception
     */
    void reduceBalance(User user, double amount) throws InsufficientBalanceException;
}
