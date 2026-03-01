package org.lisovskyi.backend.dto.response;

import org.lisovskyi.backend.enums.Role;

import java.time.LocalDateTime;

/**
 *
 *
 *
 */

public record UserResponse(Long id, String username, String email, Role role, boolean isActive,
                           boolean isVerified, LocalDateTime lastLoginAt) {}
