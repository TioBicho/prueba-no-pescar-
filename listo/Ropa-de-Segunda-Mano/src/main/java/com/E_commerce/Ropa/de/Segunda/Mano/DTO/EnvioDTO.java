package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EnvioDTO {

    @NotNull(message = "El ID de la venta es obligatorio")
    private Long ventaId;

    @NotBlank(message = "La dirección de destino no puede estar vacía")
    private String direccionDestino;

    @NotBlank(message = "Debe especificar la empresa de transporte (ej: Starken, ChilePost)")
    private String transportista;
}