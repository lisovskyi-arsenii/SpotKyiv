package org.lisovskyi.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;

@Entity
@Table(name = "interests")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Interests extends BaseEntity {

    @Column(name = "name", nullable = false, length = EntityConstraints.Interests.NAME_MAX_LENGTH)
    private String name;
}
