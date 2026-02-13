package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = { "country" })
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "city_id")
    private Integer cityId;

    @Column(nullable = true)
    private String city;

    /*
     * @Column(nullable = true,name = "country_id")
     * private Integer countryId;
     */

    // agregamos la relacion
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(nullable = true, name = "last_update", insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

}
