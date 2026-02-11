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
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @Id
    @Column(name = "customer_id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "store_id", nullable = true)
    private Integer storeId;

    @Column(name = "first_name", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = true)
    private String lastName;

    private String email;

    @Column(name = "address_id", nullable = true)
    private Integer addressId;

    @Column(name = "activebool", nullable = true, insertable = false)
    private Boolean activeBool;

    @Column(name = "create_date", nullable = true, insertable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "last_update", insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

    @Column(insertable = false)
    private Integer active;

}
