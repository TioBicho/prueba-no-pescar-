package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StockDTO {

    @NotNull(message = "El ID de la prenda del catálogo es obligatorio")
    private Long prendaId;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @NotNull
    private Integer cantidad;

    @NotBlank(message = "El estado físico es obligatorio (ej: Excelente, Desgastado)")
    private String estadoFisico;

    @NotBlank(message = "Debe indicar la ubicación en bodega")
    private String ubicacionBodega;
}