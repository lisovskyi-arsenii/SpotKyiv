package org.lisovskyi.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.lisovskyi.backend.dto.request.UserRequest;
import org.lisovskyi.backend.dto.response.UserResponse;
import org.lisovskyi.backend.entity.User;
import org.lisovskyi.backend.exception.UserNotFound;
import org.lisovskyi.backend.mapper.UserMapper;
import org.lisovskyi.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final UserMapper mapper;


    @GetMapping
    public Page<UserResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        return service.getAllUsers(PageRequest.of(page, size))
                .map(mapper::toUserResponse);
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable long id) {
        var user = service.getUserById(id)
                .orElseThrow(() -> new UserNotFound("User with id " + id + " not found"));

        return mapper.toUserResponse(user);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest request) {
        User user = mapper.toEntity(request);
        User saved = service.createUser(user);
        UserResponse response = mapper.toUserResponse(saved);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable long id,
                                                   @RequestBody @Valid UserRequest request) {
        User newUser = mapper.toEntity(request);
        User updatedUser = service.updateUser(id, newUser);

        return ResponseEntity.ok(mapper.toUserResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        if (!service.existsById(id)) {
            throw new UserNotFound("User with id " + id + " not found");
        }

        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
