package org.lisovskyi.backend.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum Role implements BaseEnum {
    USER("user"),
    ADMIN("admin"),
    MODERATOR("moderator");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getValue() {
        return roleName;
    }

    public static Optional<Role> fromRoleName(String roleName) {
        return Arrays.stream(Role.values())
                .filter(role -> role.roleName.equalsIgnoreCase(roleName))
                .findFirst();
    }
}
