package org.lisovskyi.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.lisovskyi.backend.constants.EntityConstraints;

import java.math.BigDecimal;

@Entity
@Table(name = "locations")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Locations extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private Users user;

    @Column(name = "name", nullable = false, length = EntityConstraints.Locations.NAME_MAX_LENGTH)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "latitude", nullable = false, precision = EntityConstraints.Locations.LATITUDE_PRECISION, scale = EntityConstraints.Locations.LATITUDE_SCALE)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = EntityConstraints.Locations.LONGITUDE_PRECISION, scale = EntityConstraints.Locations.LONGITUDE_SCALE)
    private BigDecimal longitude;
}
