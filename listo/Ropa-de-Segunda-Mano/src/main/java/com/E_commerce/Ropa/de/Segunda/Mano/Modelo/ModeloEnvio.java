package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
public class ModeloEnvio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ventaId;
    private String direccionDestino;
    private String transportista;
    private String numeroSeguimiento;
    private String estado; // EN_PREPARACION, EN_TRANSITO, ENTREGADO
    private LocalDateTime fechaCreacion;
}