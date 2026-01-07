package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class Language {

@Id
@Column(name = "language_id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer language_id;

@Column(name = "name",nullable = true,length = 20)
private String name;

@Column(name = "last_update", nullable = true)
private LocalDateTime last_update;


}
