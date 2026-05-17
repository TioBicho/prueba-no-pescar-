package com.E_commerce.Ropa.de.Segunda.Mano.Repositorio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByPrendaId(Long prendaId);
}