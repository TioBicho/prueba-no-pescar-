package com.e_commerce.ms_perfil.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Perfil")
public class ModeloPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_gen")
    @SequenceGenerator(name = "perfil_gen", sequenceName = "PERFIL_SEQ", allocationSize = 1)
    @Column(name = "id_perfil")
    private Long idPerfil;

    @Column(name = "telefono", nullable = false, length = 12)
    private String telefono;
}