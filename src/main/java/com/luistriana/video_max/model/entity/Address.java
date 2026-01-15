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
@Table(name = "address")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    // atributos
    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer addressId;

    @Column(nullable = true)
    private String address;

    private String address2;

    @Column(nullable = true)
    private String district;

    @Column(name = "city_id", nullable = true)
    private Integer cityId;

    @Column(name = "postal_code")

    private String postalCode;

    @Column(nullable = true)
    private String phone;

    @Column(name = "last_update",nullable = true)
    private LocalDateTime lastUpdate;

}
