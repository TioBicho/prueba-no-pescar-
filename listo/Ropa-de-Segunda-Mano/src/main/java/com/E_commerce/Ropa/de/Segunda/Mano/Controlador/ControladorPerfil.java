package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.PerfilDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloPerfil;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.ServicioPerfil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perfiles")
public class ControladorPerfil {

    @Autowired
    private ServicioPerfil servicio;

    @PostMapping
    public ResponseEntity<ModeloPerfil> guardar(@Valid @RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(servicio.actualizarOCrear(dto));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<ModeloPerfil> buscar(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(servicio.obtenerPorUsuario(usuarioId));
    }
}