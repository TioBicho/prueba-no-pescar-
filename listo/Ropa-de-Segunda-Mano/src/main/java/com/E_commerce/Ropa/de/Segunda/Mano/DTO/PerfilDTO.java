package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class PerfilDTO {

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @Size(max = 15, message = "El teléfono es muy largo")
    private String telefono;

    private String direccion;
    
    private String biografia;
}