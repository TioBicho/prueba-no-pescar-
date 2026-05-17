package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioPerfil extends JpaRepository<ModeloPerfil, Long> {
    Optional<ModeloPerfil> findByUsuarioId(Long usuarioId);
}