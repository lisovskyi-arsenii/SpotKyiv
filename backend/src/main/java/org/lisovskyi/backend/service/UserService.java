package org.lisovskyi.backend.service;

import org.lisovskyi.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    Optional<User> getUserById(long id);
    User createUser(User user);
    User updateUser(long id, User newUser);
    void deleteUserById(long id);
    boolean existsById(long id);
}
