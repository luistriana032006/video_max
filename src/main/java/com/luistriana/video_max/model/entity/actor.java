package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "actor")
public class actor {

    // columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actor_id;

    @Column(nullable = true)

    private String frist_name;
    @Column(nullable = true)
    private String last_name;

    // ultima actualiazacion 
    @Column( name = "last_update")
    private LocalDateTime lastupdate;


}
