package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "catalogo_prendas")
@Data
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la prenda es obligatorio")
    private String nombre;

    @NotBlank(message = "El tipo de ropa es obligatorio (ej: Polera, Pantalón)")
    private String tipo;

    @NotBlank(message = "El material es obligatorio")
    private String material;

    @NotBlank(message = "El estilo es obligatorio (ej: Vintage, Deportivo)")
    private String estilo;

    @Positive(message = "El precio base debe ser mayor a cero")
    private Double precioBase;
}