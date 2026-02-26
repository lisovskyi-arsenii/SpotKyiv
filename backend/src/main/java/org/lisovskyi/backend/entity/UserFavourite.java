package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.embeddable.UsersFavouritesId;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_favourites")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class UserFavourite {

    @EmbeddedId
    private UsersFavouritesId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locationId")
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "saved_at", nullable = false, updatable = false)
    private LocalDateTime savedAt;

    @PrePersist
    public void prePersist() {
        this.savedAt = LocalDateTime.now();
    }
}
