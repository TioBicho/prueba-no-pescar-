package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEnvio extends JpaRepository<ModeloEnvio, Long> {
}