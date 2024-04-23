package com.github.dschreid.shop.server.repository;

import com.github.dschreid.shop.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository that holds Users
 *
 * @author dschreid
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find user by username.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findByUsername(String username);
    /**
     * Find user by email.
     *
     * @param email the email
     * @return the optional
     */
    Optional<User> findByEmail(String email);
}
