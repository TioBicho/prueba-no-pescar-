package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class ModeloEmpleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String rut;

    private String nombre;
    private String cargo;
    private Double salarioBase;
    private String email;
    private boolean activo = true;
}