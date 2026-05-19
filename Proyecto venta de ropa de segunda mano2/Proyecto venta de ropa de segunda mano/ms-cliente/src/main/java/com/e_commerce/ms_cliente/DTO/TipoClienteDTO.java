package com.e_commerce.ms_cliente.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoClienteDTO {

    @NotBlank(message = "La categoría del cliente es obligatoria.")
    @Size(max = 8, message = "La categoría no puede superar los 8 caracteres.") // VARCHAR2(8) en tu DDL
    private String categoriaCliente;

    @NotNull(message = "La cantidad de puntos iniciales no puede ser nula.")
    private Integer puntos; // NUMBER(9) en tu DDL
}