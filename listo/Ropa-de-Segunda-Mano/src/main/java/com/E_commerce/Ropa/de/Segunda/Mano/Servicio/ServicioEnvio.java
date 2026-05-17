package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.EnvioDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEnvio;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioEnvio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class ServicioEnvio {

    @Autowired
    private RepositorioEnvio repositorio;

    public ModeloEnvio crearEnvio(EnvioDTO dto) {
        log.info("Creando registro de envío para Venta ID: {}", dto.getVentaId());

        ModeloEnvio envio = new ModeloEnvio();
        envio.setVentaId(dto.getVentaId());
        envio.setDireccionDestino(dto.getDireccionDestino());
        envio.setTransportista(dto.getTransportista());
        
        // Lógica de negocio: Generar tracking único y estado inicial
        envio.setNumeroSeguimiento("TRK-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        envio.setEstado("EN_PREPARACION");
        envio.setFechaCreacion(LocalDateTime.now());

        return repositorio.save(envio);
    }
}