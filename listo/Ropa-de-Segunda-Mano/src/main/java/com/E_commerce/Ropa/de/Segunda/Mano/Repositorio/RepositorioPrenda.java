package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    // Permite filtrar por tipo para búsquedas en el catálogo
    List<Prenda> findByTipo(String tipo);
}