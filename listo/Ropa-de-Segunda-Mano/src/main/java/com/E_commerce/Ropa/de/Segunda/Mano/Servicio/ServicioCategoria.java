package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.CategoriaDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloCategoria;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioCategoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ServicioCategoria {

    @Autowired
    private RepositorioCategoria repositorio;

    public ModeloCategoria crearCategoria(CategoriaDTO dto) {
        log.info("Creando nueva categoría de ropa: {}", dto.getNombre());
        
        ModeloCategoria categoria = new ModeloCategoria();
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        
        return repositorio.save(categoria);
    }

    public List<ModeloCategoria> obtenerTodas() {
        log.info("Consultando todas las categorías disponibles");
        return repositorio.findAll();
    }
}