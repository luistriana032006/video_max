package com.luistriana.video_max.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = " payment")
public class Payment {
// columnas

@Column(name = "payment_id")
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer paymentId;

@Column(name = "customer_id", nullable =  true)
private Integer customerId;

@Column(name = "staff_id ",nullable = true)
private Integer staffId;

@Column(name = "rental_id", nullable =  true)
private Integer rentalId;

@Column ( name = " amount", nullable = true, length = 5,scale = 2)
private BigDecimal amount;


@Column(name = "payment_date")
private LocalDateTime paymentDate;


}
