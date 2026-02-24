package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.enums.Role;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Users extends BaseEntity {

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;

    @Column(name = "role", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;
}
