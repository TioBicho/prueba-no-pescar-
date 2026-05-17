package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.CategoriaDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloCategoria;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.ServicioCategoria;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class ControladorCategoria {

    @Autowired
    private ServicioCategoria servicio;

    @PostMapping
    public ResponseEntity<ModeloCategoria> crear(@Valid @RequestBody CategoriaDTO dto) {
        return new ResponseEntity<>(servicio.crearCategoria(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModeloCategoria>> listar() {
        return ResponseEntity.ok(servicio.obtenerTodas());
    }
}