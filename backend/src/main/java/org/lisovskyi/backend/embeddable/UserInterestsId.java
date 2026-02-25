package org.lisovskyi.backend.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data @NoArgsConstructor @AllArgsConstructor
public class UserInterestsId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "interest_id")
    private Long interestId;
}
