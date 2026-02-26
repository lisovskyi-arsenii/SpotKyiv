package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;
import org.lisovskyi.backend.enums.Role;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, length = EntityConstraints.Users.USERNAME_MAX_LENGTH)
    private String username;

    @Column(name = "email", nullable = false, unique = true, length = EntityConstraints.Users.EMAIL_MAX_LENGTH)
    private String email;

    @Column(name = "password_hash", nullable = false, length = EntityConstraints.Users.PASSWORD_MAX_LENGTH)
    private String passwordHash;

    @Column(name = "role", nullable = false, length = EntityConstraints.Users.ROLE_MAX_LENGTH)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified = false;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;
}
