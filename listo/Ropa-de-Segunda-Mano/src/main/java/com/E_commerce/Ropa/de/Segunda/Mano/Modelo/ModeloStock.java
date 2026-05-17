package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inventario_stock")
@Data
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long prendaId; // Relación lógica con MS-Catalogo
    private Integer cantidad;
    private String estadoFisico;
    private String ubicacionBodega;
}