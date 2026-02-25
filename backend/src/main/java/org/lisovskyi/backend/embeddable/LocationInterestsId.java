package org.lisovskyi.backend.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class LocationInterestsId implements Serializable {
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "interest_id")
    private Long interestId;
}
