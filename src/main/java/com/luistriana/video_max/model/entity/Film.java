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
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer filmId;

    private String title;

    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "original_language_id")
    private Integer originalLanguageId;

    @Column(name = "rental_duration", insertable = false)
    private Short rentalDuration;

    @Column(name = "rental_rate", precision = 4, scale = 2, insertable = false)
    private BigDecimal rentalRate;

    @Column(name = "replacement_cost", precision = 5, scale = 2, insertable = false)
    private BigDecimal replacementCost;

    private Short length;

    @Column(name = "rating", insertable = false)
    private MpaaRating rating;

    @Column(name = "last_update", insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

    @Type(StringArrayType.class)
    @Column(name = "special_features")
    private String[] specialFeatures;

}
