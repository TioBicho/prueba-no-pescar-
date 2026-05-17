package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RepositorioUsuario extends JpaRepository<ModeloUsuario, Long> {
    Optional<ModeloUsuario> findByUsername(String username);
}