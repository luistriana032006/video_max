package com.luistriana.video_max.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = " inventory")
@Setter
@Getter
@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer inventoryId;

    @Column(name = "film_id", nullable = true)
    private Integer filmId;

    @Column(name = "store_id", nullable = true, insertable = false, updatable = false)
    private Integer storeId;

    
}
