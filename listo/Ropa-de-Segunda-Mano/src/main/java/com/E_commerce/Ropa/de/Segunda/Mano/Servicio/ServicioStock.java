package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.StockDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Stock;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository repository;

    public Stock actualizarInventario(StockDTO dto) {
        log.info("Actualizando stock para la prenda ID: {}", dto.getPrendaId());
        
        // Buscar si ya existe stock para esa prenda o crear uno nuevo
        Stock entidad = repository.findByPrendaId(dto.getPrendaId())
                .orElse(new Stock());
        
        entidad.setPrendaId(dto.getPrendaId());
        entidad.setCantidad(dto.getCantidad());
        entidad.setEstadoFisico(dto.getEstadoFisico());
        entidad.setUbicacionBodega(dto.getUbicacionBodega());

        return repository.save(entidad);
    }

    // Método vital para la defensa: Descontar stock cuando hay una venta
    public void descontarStock(Long prendaId, Integer cantidadAVender) {
        Stock stock = repository.findByPrendaId(prendaId)
                .orElseThrow(() -> new RuntimeException("No hay registro de stock para esta prenda"));

        if (stock.getCantidad() < cantidadAVender) {
            log.error("Intento de venta sin stock suficiente para prenda ID: {}", prendaId);
            throw new RuntimeException("Stock insuficiente");
        }

        stock.setCantidad(stock.getCantidad() - cantidadAVender);
        repository.save(stock);
        log.info("Stock descontado. Nueva cantidad: {}", stock.getCantidad());
    }
}