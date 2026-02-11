package com.luistriana.video_max.model.entity;

import java.math.BigDecimal;
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
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Payment {

    @Column(name = "payment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer paymentId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "staff_id")
    private Integer staffId;

    @Column(name = "rental_id")
    private Integer rentalId;

    @Column(name = "amount", precision = 5, scale = 2)
    private BigDecimal amount;

    @Column(name = "payment_date")
    private LocalDateTime paymentDate;

    @Column(name = "last_update", insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

}
