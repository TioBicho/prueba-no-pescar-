package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.UsuarioDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloUsuario;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repositorio;

    public ModeloUsuario registrarUsuario(UsuarioDTO dto) {
        log.info("Registrando nuevo usuario en el sistema: {}", dto.getUsername());
        
        ModeloUsuario usuario = new ModeloUsuario();
        usuario.setUsername(dto.getUsername());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword()); // En un caso real, aquí se encriptaría
        usuario.setRol(dto.getRol());
        
        return repositorio.save(usuario);
    }

    public ModeloUsuario buscarPorUsername(String username) {
        return repositorio.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}