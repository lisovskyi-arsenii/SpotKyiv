package org.lisovskyi.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.lisovskyi.backend.constants.EntityConstraints;
import org.lisovskyi.backend.enums.Role;

/**
 * DTO for creating or updating a user.
 * <p>
 * Used as a request body in {@code POST /users} and {@code PUT /users/{id}} endpoints.
 * Contains validated user input data. Sensitive fields like {@code passwordHash}
 * and server-managed fields like {@code isVerified}, {@code isActive} are excluded.
 * </p>
 *
 * @param username the user's display name; must not be blank and must not exceed
 *                 {@link EntityConstraints.Users#USERNAME_MAX_LENGTH} characters
 * @param email    the user's email address; must be a valid email format and not exceed
 *                 {@link EntityConstraints.Users#EMAIL_MAX_LENGTH} characters
 * @param password the user's raw password; must be between 8 and
 *                 {@link EntityConstraints.Users#PASSWORD_MAX_LENGTH} characters (will be hashed before saving)
 * @param role     the user's role in the system; must not be null
 * <p>
 * Note: I use @NotNull for the enum field {@code role} because it is required and cannot be blank.
*       The @NotBlank annotation is not applicable to enum types,
        so @NotNull is used to ensure that a value is provided for the role.
        The validation will check that the role is not null, and since it's an enum,
        it will also ensure that the value provided is one of the defined enum constants.
 * </p>
 */
public record UserRequest(
        @NotBlank(message = "Username is required")
        @Size(max = EntityConstraints.Users.USERNAME_MAX_LENGTH, message = "Username must be at most " + EntityConstraints.Users.USERNAME_MAX_LENGTH + " characters")
        String username,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        @Size(max = EntityConstraints.Users.EMAIL_MAX_LENGTH)
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, max = EntityConstraints.Users.PASSWORD_MAX_LENGTH, message = "Password must be between 8 and " + EntityConstraints.Users.PASSWORD_MAX_LENGTH + " characters")
        String password,

        @NotNull(message = "Role is required")
        Role role
) {}
