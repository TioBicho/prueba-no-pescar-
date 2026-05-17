package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.List;

@Data
public class VentaDTO {
    @NotNull(message = "El cliente es obligatorio")
    private Long clienteId;

    @NotEmpty(message = "La venta debe tener al menos un producto")
    private List<DetalleVentaDTO> productos;
}

@Data
class DetalleVentaDTO {
    private Long prendaId;
    private Integer cantidad;
}