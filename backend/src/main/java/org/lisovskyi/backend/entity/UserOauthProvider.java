package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;
import org.lisovskyi.backend.enums.Provider;

@Entity
@Table(
        name = "user_oauth_providers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_provider_uid_per_user",
                        columnNames = {"provider", "provider_uid"}
                )
        }
)
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserOauthProvider extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false, length = EntityConstraints.UserOauthProvider.PROVIDER_MAX_LENGTH)
    private Provider provider;

    @Column(name = "provider_uid", nullable = false, length = EntityConstraints.UserOauthProvider.PROVIDER_UID_MAX_LENGTH)
    private String providerUserId;
}
