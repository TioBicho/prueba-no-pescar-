package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Prenda;
import com.E_commerce.Ropa.de.Segunda.Mano.DTO.PrendaDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.PrendaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrendaService {

    @Autowired
    private PrendaRepository repository;

    public Prenda guardarConDTO(PrendaDTO dto) {
        log.info("Transformando DTO a Entidad para la prenda: {}", dto.getNombre());
        
        // Mapeo manual (IE 2.2.1 Reglas de negocio)
        Prenda entidad = new Prenda();
        entidad.setNombre(dto.getNombre());
        entidad.setTipo(dto.getTipo());
        entidad.setMaterial(dto.getMaterial());
        entidad.setPrecioBase(dto.getPrecioBase());
        
        return repository.save(entidad);
    }
}