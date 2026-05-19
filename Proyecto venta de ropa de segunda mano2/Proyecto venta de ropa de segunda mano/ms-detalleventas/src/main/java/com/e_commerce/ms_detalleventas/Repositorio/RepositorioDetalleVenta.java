package com.e_commerce.ms_detalleventas.Repositorio;

import com.e_commerce.ms_detalleventas.Modelo.ModeloDetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDetalleVenta extends JpaRepository<ModeloDetalleVenta, Long> {

    // genera automáticamente el SQL para traer todas las líneas de una boleta específica
    List<ModeloDetalleVenta> findByVentaId(Long ventaId);

    // Consulta personalizada para buscar qué ventas incluyeron un SKU de prenda específico
    @Query("SELECT d FROM ModeloDetalleVenta d WHERE d.ropaId = :ropaId")
    List<ModeloDetalleVenta> buscarPorSkuPrenda(@Param("ropaId") String ropaId);
}