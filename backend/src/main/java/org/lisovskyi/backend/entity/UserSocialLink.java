package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;
import org.lisovskyi.backend.enums.Platform;

@Entity
@Table(
        name = "user_social_links",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_user_platform",
                        columnNames = {"user_id", "platform"}
                )
        }
)
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserSocialLink extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform", nullable = false, length = EntityConstraints.UserSocialLinks.PLATFORM_MAX_LENGTH)
    private Platform platform;

    @Column(name = "url", nullable = false, length = EntityConstraints.UserSocialLinks.URL_MAX_LENGTH)
    private String url;
}
