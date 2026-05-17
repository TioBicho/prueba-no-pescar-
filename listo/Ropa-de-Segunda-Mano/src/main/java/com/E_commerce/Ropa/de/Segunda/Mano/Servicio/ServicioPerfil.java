package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.PerfilDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloPerfil;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioPerfil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServicioPerfil {

    @Autowired
    private RepositorioPerfil repositorio;

    public ModeloPerfil actualizarOCrear(PerfilDTO dto) {
        log.info("Actualizando perfil para el usuario ID: {}", dto.getUsuarioId());
        
        // Buscamos si ya existe, si no, creamos uno nuevo
        ModeloPerfil perfil = repositorio.findByUsuarioId(dto.getUsuarioId())
                .orElse(new ModeloPerfil());
        
        perfil.setUsuarioId(dto.getUsuarioId());
        perfil.setNombreCompleto(dto.getNombreCompleto());
        perfil.setTelefono(dto.getTelefono());
        perfil.setDireccion(dto.getDireccion());
        perfil.setBiografia(dto.getBiografia());
        
        return repositorio.save(perfil);
    }

    public ModeloPerfil obtenerPorUsuario(Long usuarioId) {
        return repositorio.findByUsuarioId(usuarioId)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
    }
}