package com.E_commerce.Ropa.de.Segunda.Mano.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class NominaDTO {

    @NotNull(message = "Debe indicar el ID del empleado")
    private Long empleadoId;

    @NotNull(message = "La fecha de pago es requerida")
    private LocalDate fechaPago;

    @Positive(message = "El salario base debe ser mayor a cero")
    @NotNull(message = "El salario base no puede ser nulo")
    private Double salarioBase;

    @Min(value = 0, message = "Los bonos no pueden ser negativos")
    private Double bonos;

    @NotBlank(message = "Debe especificar un estado (PAGADO/PENDIENTE)")
    private String estado;
}