package com.github.dschreid.shop.server.service;

import com.github.dschreid.shop.server.dto.request.RegisterRequest;
import com.github.dschreid.shop.server.exception.InsufficientBalanceException;
import com.github.dschreid.shop.server.exception.UserAlreadyExistsException;
import com.github.dschreid.shop.server.mapper.UserMapper;
import com.github.dschreid.shop.server.model.Role;
import com.github.dschreid.shop.server.model.User;
import com.github.dschreid.shop.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.createDefault();
    }

    private void createDefault() {
        if (repository.count() != 0) return;

        final User admin = new User("admin", "admin", "admin@nowhereto.go");
        admin.setRoles(Set.of(Role.ADMIN));
        repository.save(admin);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public void register(RegisterRequest register) throws UserAlreadyExistsException {
        if (findUserByUsername(register.getUsername()).isPresent()) throw new UserAlreadyExistsException();
        if (findUserByEmail(register.getEmail()).isPresent()) throw new UserAlreadyExistsException();

        repository.save(mapper.fromRegister(register));
    }

    @Override
    public void addBalance(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        repository.save(user);
    }

    @Override
    public void reduceBalance(User user, double amount) throws InsufficientBalanceException {
        if (user.getBalance() < amount) throw new InsufficientBalanceException();

        user.setBalance(user.getBalance() - amount);
        repository.save(user);
    }
}
