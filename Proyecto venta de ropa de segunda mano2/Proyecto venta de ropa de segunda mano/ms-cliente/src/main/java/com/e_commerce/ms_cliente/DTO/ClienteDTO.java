package com.e_commerce.ms_cliente.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotNull(message = "El RUT es obligatorio.")
    private Long rut;

    @NotNull(message = "El dígito verificador es obligatorio.")
    @Min(value = 0, message = "El DV no puede ser un número negativo.")
    @Max(value = 9, message = "El DV no puede ser un número mayor a 9.")
    private Integer dv;

    @NotBlank(message = "El nombre del cliente es obligatorio.")
    @Size(max = 9, message = "El nombre de cliente no puede superar los 9 caracteres.")
    private String nombreCliente;

    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El apellido paterno es obligatorio.")
    @Size(max = 15, message = "El apellido paterno no puede superar los 15 caracteres.")
    private String papellido;

    @NotBlank(message = "El apellido materno es obligatorio.")
    @Size(max = 15, message = "El apellido materno no puede superar los 15 caracteres.")
    private String mapellido;

    @NotNull(message = "El ID del tipo de cliente es obligatorio.")
    private Long tipoClienteId;

    @NotNull(message = "El ID del usuario asociado es obligatorio.")
    private Long usuarioIdUsuario;
}