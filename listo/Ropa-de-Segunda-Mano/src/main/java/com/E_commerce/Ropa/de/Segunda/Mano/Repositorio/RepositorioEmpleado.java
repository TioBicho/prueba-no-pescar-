package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<ModeloEmpleado, Long> {
}