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
@Table(name =  "city")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@EqualsAndHashCode.Include
private Integer cityId;

@Column(nullable =  true)
private String city;

@Column(nullable = true)
private Integer countryId;

@Column(nullable = true)
private LocalDateTime lastUpdate;




}
