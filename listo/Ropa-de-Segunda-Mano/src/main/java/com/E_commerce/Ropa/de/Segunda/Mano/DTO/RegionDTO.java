package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegionDTO {

    @NotBlank(message = "El nombre de la región no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El costo de envío es obligatorio")
    @PositiveOrZero(message = "El costo de envío no puede ser negativo")
    private Double costoEnvioBase;
}