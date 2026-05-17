package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.VentaDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloVenta; 
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioVenta;
import com.E_commerce.Ropa.de.Segunda.Mano.Cliente.StockCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ServicioVenta {

    @Autowired 
    private RepositorioVenta repositorioVenta;
    
    @Autowired 
    private StockClient stockClient;

    @Transactional
    public ModeloVenta procesarVenta(VentaDTO dto) {
        log.info("Iniciando venta para el cliente ID: {}", dto.getClienteId());

        ModeloVenta venta = new ModeloVenta();
        venta.setClienteId(dto.getClienteId());
        venta.setTotal(15000.0); // Esto es un ejemplo

        
        dto.getProductos().forEach(prod -> {
    log.info("Llamando a MS-STOCK para prenda {}", prod.getPrendaId());
    
    stockClient.descontarStock(prod.getPrendaId(), prod.getCantidad()); }); 

        return repositorioVenta.save(venta);
    }
}