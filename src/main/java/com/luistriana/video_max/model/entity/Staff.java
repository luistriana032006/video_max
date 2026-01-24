package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;

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

@Entity
@Table(name = "staff")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Staff {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "staff_id")
private Integer staffId;


private String firstName;

private String lastName;

private Integer addressId;

private String email;

private Integer storeId;


private Boolean active;

private String username;


private String password;

private LocalDateTime last_update;


private Byte[] picture;



}
