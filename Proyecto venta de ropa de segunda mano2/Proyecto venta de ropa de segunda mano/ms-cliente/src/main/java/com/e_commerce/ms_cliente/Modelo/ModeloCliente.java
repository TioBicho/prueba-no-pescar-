package com.e_commerce.ms_cliente.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class ModeloCliente {

    @Id
    @Column(name = "RUT")
    private Long rut;

    @Column(name = "DV", nullable = false)
    private Integer dv;

    @Column(name = "NOMBRE_CLIENTE", nullable = false, length = 9)
    private String nombreCliente;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "PAPELLIDO", nullable = false, length = 15)
    private String papellido;

    @Column(name = "MAPELLIDO", nullable = false, length = 15)
    private String mapellido;

    @Column(name = "TIPO_CLIENTE_ID", nullable = false)
    private Long tipoClienteId;

    @Column(name = "USUARIO_ID_USUARIO", nullable = false)
    private Long usuarioIdUsuario;
}