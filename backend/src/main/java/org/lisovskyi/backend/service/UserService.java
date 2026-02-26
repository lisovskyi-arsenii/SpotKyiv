package org.lisovskyi.backend.service;

import lombok.RequiredArgsConstructor;
import org.lisovskyi.backend.entity.User;
import org.lisovskyi.backend.exception.InvalidUser;
import org.lisovskyi.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // I use this annotation to generate a constructor with required arguments (final fields) - inject repository
public class UserService {
    private final UserRepository repository;

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Transactional()
    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    @Transactional
    public User createUser(User user) {
        return repository.save(user);
    }

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public Optional<User> updateUser(long id, User newUser) {
        User currentUser = repository.findById(id)
                        .orElseThrow(() -> new InvalidUser("User with id " + id + " not found"));

        currentUser.setUsername(newUser.getUsername());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setRole(newUser.getRole());
        currentUser.setIsActive(newUser.getIsActive());
        currentUser.setLastLoginAt(newUser.getLastLoginAt());
        currentUser.setIsVerified(newUser.getIsVerified());

        repository.save(currentUser);
        return Optional.of(currentUser);
    }

    @Transactional
    public void deleteUserById(long id) {
        repository.deleteById(id);
    }
}
