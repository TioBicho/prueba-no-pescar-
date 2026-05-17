package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmpleadoDTO {

    @NotBlank(message = "El RUT o ID de empleado es obligatorio")
    private String rut;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombre;

    @NotBlank(message = "El cargo es obligatorio (ej: Bodeguero, Vendedor)")
    private String cargo;

    @Positive(message = "El salario base debe ser positivo")
    private Double salarioBase;

    @Email(message = "Correo electrónico inválido")
    private String email;
}