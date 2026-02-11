package com.luistriana.video_max.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FilmCategoryId implements Serializable {

    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "category_id")
    private Integer categoryId;

}
