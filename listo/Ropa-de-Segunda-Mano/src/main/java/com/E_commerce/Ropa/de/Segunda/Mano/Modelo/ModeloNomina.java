package com.E_commerce.Ropa.de.Segunda.Mano.Modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "nominas")
@Data
public class Nomina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del empleado es obligatorio")
    private Long empleadoId;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDate fechaPago;

    @Positive(message = "El salario base debe ser un monto positivo")
    @NotNull
    private Double salarioBase;

    @Min(value = 0, message = "Los bonos no pueden ser negativos")
    private Double bonos;

    @NotBlank(message = "El estado del pago es obligatorio")
    private String estado; // Ejemplo: PENDIENTE, PAGADO
}