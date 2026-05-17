package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "regiones")
@Data
public class ModeloRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double costoEnvioBase;
}