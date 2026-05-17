package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PrendaDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;
    
    @NotBlank(message = "El material es obligatorio")
    private String material;
    
    @Positive(message = "El precio debe ser mayor a cero")
    private Double precioBase;
}