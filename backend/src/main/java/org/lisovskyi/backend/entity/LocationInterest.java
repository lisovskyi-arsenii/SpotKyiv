package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.embeddable.LocationInterestsId;

@Entity
@Table(name = "location_interests")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class LocationInterest {

    @EmbeddedId
    private LocationInterestsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("locationId")
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("interestId")
    @JoinColumn(name = "interest_id", nullable = false)
    private Interest interest;
}
