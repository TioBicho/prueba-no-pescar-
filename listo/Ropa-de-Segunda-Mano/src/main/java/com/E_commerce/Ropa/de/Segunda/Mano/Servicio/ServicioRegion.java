package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.RegionDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloRegion;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioRegion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ServicioRegion {

    @Autowired
    private RepositorioRegion repositorio;

    public ModeloRegion guardar(RegionDTO dto) {
        log.info("Registrando nueva región: {}", dto.getNombre());
        
        ModeloRegion region = new ModeloRegion();
        region.setNombre(dto.getNombre());
        region.setCostoEnvioBase(dto.getCostoEnvioBase());
        
        return repositorio.save(region);
    }

    public List<ModeloRegion> listarTodas() {
        log.info("Obteniendo lista completa de regiones");
        return repositorio.findAll();
    }
}