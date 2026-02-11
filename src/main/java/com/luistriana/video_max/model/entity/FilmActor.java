package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@Getter
@Setter
@NoArgsConstructor
public class FilmActor {

    @Column(name = "last_update", insertable = false, unique = false)
    private LocalDateTime lastUpdate;

    @EmbeddedId
    private FilmActorId id;

}
