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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "rental")
public class Rental {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "rental_date", nullable = true)
    private LocalDateTime rentalDate;

    @Column(name = "inventory_id", nullable = true)
    private Integer inventoryId;

    @Column(name = "customer_id", nullable = true)
    private Integer customerId;

    @Column(name = "return_date", nullable = true)
    private LocalDateTime returnDate;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "last_update", insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

}
