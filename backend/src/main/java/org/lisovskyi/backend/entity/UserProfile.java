package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;

import java.time.LocalDate;

@Entity
@Table(name = "users_profile")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserProfile extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            referencedColumnName = "id",
            nullable = false,
            unique = true)
    private User user;

    @Column(name = "last_name", nullable = false, length = EntityConstraints.UsersProfile.NAME_MAX_LENGTH)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = EntityConstraints.UsersProfile.NAME_MAX_LENGTH)
    private String firstName;

    @Column(name = "second_name", length = EntityConstraints.UsersProfile.NAME_MAX_LENGTH)
    private String secondName;

    @Column(name = "phone_number", length = EntityConstraints.UsersProfile.PHONE_NUMBER_MAX_LENGTH)
    private String phoneNumber;

    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_picture_url", length = EntityConstraints.UsersProfile.PROFILE_PICTURE_URL_MAX_LENGTH)
    private String profilePictureUrl;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
}
