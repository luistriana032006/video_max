package com.luistriana.video_max.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.Type;

import com.luistriana.video_max.model.entity.enums.MpaaRating;

import io.hypersistence.utils.hibernate.type.array.StringArrayType;
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

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@Table(name = "film")
public class Film {

    // atributos - columnas
    @Id
    @Column(name = " film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer filmId;

    @Column(unique = true)
    private String text;

    private String description;

    private Integer year;

    @Column(name = "language_id", unique = true)
    private Integer languageId;

    @Column(name = "original_language", unique = true)
    private Integer originalLanguage;

    @Column(name = "rental_duration", unique = true)
    private short rentalDuration;

    @Column(name = "rental_date", unique = true, length = 4, scale = 2)
    private BigDecimal rentalDate;

    @Column(name = "replacement_cost", unique = true, length = 5, scale = 2)
    private BigDecimal replacementCost;

    private Short length;

    @Column(name = "mpaa_rating")
    private MpaaRating mpaaRating;

    @Column(name = "last_update", unique = true)
    private LocalDateTime lastUpdate;

    @Type(StringArrayType.class)
    @Column(name = "especial_features")
    private String[] especialFeatures;

}
