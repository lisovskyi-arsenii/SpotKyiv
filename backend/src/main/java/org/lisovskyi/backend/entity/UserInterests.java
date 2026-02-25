package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.embeddable.UserInterestsId;

@Entity
@Table(name = "user_interests")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserInterests {

    @EmbeddedId
    private UserInterestsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("interestId")
    @JoinColumn(name = "interest_id", nullable = false)
    private Interests interest;
}
