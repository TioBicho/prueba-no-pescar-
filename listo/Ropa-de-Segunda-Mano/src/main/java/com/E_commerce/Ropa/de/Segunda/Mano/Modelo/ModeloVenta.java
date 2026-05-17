package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long clienteId;
    private LocalDateTime fecha = LocalDateTime.now();
    private Double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "venta_id")
    private List<VentaDetalle> detalles;
}

@Entity
@Data
class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long prendaId;
    private Integer cantidad;
    private Double precioUnitario;
}