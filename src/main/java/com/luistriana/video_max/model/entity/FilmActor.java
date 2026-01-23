package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@Getter
@Setter

// para que el to String responder en claude
public class FilmActor {

    @Column(name = "last_update", insertable = false, unique = false)
    private LocalDateTime lastUpdate;

    @EmbeddedId
    private FilmActorId id;

}
