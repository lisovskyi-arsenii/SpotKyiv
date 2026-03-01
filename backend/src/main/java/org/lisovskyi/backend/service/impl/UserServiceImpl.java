package org.lisovskyi.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.lisovskyi.backend.entity.User;
import org.lisovskyi.backend.exception.UserNotFound;
import org.lisovskyi.backend.repository.UserRepository;
import org.lisovskyi.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // I use this annotation to generate a constructor with required arguments (final fields) - inject repository
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Page<User> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(long id, User newUser) {
        User currentUser = repository.findById(id)
                        .orElseThrow(() -> new UserNotFound("User with id " + id + " not found"));

        currentUser.setUsername(newUser.getUsername());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setRole(newUser.getRole());
        currentUser.setIsActive(newUser.getIsActive());
        currentUser.setLastLoginAt(newUser.getLastLoginAt());
        currentUser.setIsVerified(newUser.getIsVerified());

        return repository.save(currentUser);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(long id) {
        return repository.existsById(id);
    }
}
