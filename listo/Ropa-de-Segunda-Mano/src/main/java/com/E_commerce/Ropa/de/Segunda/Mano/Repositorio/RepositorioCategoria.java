package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCategoria extends JpaRepository<ModeloCategoria, Long> {
}