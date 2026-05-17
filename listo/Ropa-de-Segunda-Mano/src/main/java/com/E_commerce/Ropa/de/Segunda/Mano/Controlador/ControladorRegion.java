package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.RegionDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloRegion;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.ServicioRegion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/regiones")
public class ControladorRegion {

    @Autowired
    private ServicioRegion servicio;

    @PostMapping
    public ResponseEntity<ModeloRegion> crear(@Valid @RequestBody RegionDTO dto) {
        return new ResponseEntity<>(servicio.guardar(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModeloRegion>> listar() {
        return ResponseEntity.ok(servicio.listarTodas());
    }
}