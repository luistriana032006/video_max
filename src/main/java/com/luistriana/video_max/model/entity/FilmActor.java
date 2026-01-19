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
import lombok.Setter;

@Entity
@Table(name = "film_actor")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FilmActor {

@Id
@Column(name = "actor_id")
@EqualsAndHashCode.Include
@GeneratedValue(strategy  = GenerationType.IDENTITY)
private Integer actorId;

@Column(name =  "film_id",nullable = true)
private Integer filmId;

private LocalDateTime lastUpdate;


}
