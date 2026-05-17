package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CategoriaDTO {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(min = 3, max = 30, message = "El nombre debe tener entre 3 y 30 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
}