package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Country {

    // columnas
    @Id
    @Column(name = "country_id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "last_update", nullable = true)
    private LocalDateTime lastUpdate;

}
