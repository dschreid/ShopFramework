package com.github.dschreid.shop.server.repository;

import com.github.dschreid.shop.server.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Repository that holds Sessions
 *
 * @author dschreid
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    /**
     * Find session by token.
     *
     * @param token user session token
     * @return session
     */
    Optional<Session> findSessionByToken(String token);
    /**
     * Delete session by.
     *
     * @param token user session token
     */
    @Transactional
    void deleteSessionByToken(String token);
}
