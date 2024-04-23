package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.LoginRequest;
import com.github.dschreid.shop.server.dto.response.AuthResponse;
import com.github.dschreid.shop.server.exception.PasswordMismatchException;
import com.github.dschreid.shop.server.exception.UnauthorizedAccessException;
import com.github.dschreid.shop.server.exception.UserNotFoundException;
import com.github.dschreid.shop.server.mapper.SessionMapper;
import com.github.dschreid.shop.server.model.Role;
import com.github.dschreid.shop.server.model.Session;
import com.github.dschreid.shop.server.model.User;
import com.github.dschreid.shop.server.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository repository;
    private final UserService userService;
    private final SessionMapper sessionMapper;

    @Autowired
    public SessionServiceImpl(SessionRepository repository, UserService userService, SessionMapper sessionMapper) {
        this.repository = repository;
        this.userService = userService;
        this.sessionMapper = sessionMapper;
    }

    @Override
    public AuthResponse login(LoginRequest loginDTO) throws UserNotFoundException, PasswordMismatchException {
        final String username = loginDTO.getUsername();
        final Optional<User> userByLogin = userService.findUserByUsername(username);

        if (userByLogin.isEmpty()) throw new UserNotFoundException();
        final User user = userByLogin.get();

        if (!Objects.equals(user.getPassword(), loginDTO.getPassword())) throw new PasswordMismatchException();

        return createSession(user);
    }

    @Override
    public User authenticate(String sessionToken) throws UnauthorizedAccessException {
        return getSession(sessionToken).map(Session::getUser).orElseThrow(UnauthorizedAccessException::new);
    }

    @Override
    public boolean logout(String sessionToken) throws UnauthorizedAccessException {
        repository.deleteSessionByToken(sessionToken);
        return true;
    }

    @Override
    public User authorize(String sessionToken) throws UnauthorizedAccessException {
        return getSession(sessionToken).orElseThrow(UnauthorizedAccessException::new).getUser();
    }

    @Override
    public User authorize(String sessionToken, Role minLevel) throws UnauthorizedAccessException {
        return authorize(authenticate(sessionToken), minLevel);
    }

    @Override
    public Optional<Session> getSession(String token) {
        return repository.findSessionByToken(token);
    }

    @Override
    public User authorize(User user, Role minLevel) throws UnauthorizedAccessException {
        if (!user.highestRole().has(minLevel)) {
            throw new UnauthorizedAccessException();
        }
        return user;
    }

    @Override
    public AuthResponse createSession(User user) {
        Session session = new Session();
        session.setUser(user);
        session.setToken(UUID.randomUUID().toString());
        session.setExpiresAt(System.currentTimeMillis() + Duration.of(1, ChronoUnit.DAYS).toMillis());
        session = repository.save(session);

        return sessionMapper.toAuthResponse(user, session);
    }
}
