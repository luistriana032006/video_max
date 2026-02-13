package com.luistriana.video_max.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = { "cities" }) // esto es para excluirlo de las mostradas de los datos
public class Country {

    // columnas
    @Id
    @Column(name = "country_id", nullable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer countryId;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "last_update", nullable = true, insertable = false, updatable = false)
    private LocalDateTime lastUpdate;

    // esto es opcional pero aprendamoslo

    @OneToMany(mappedBy = "country")
    private List<City> cities;

}
