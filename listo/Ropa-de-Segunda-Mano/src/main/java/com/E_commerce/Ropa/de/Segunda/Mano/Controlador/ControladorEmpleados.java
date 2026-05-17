package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.EmpleadoDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEmpleado;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.ServicioEmpleado;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class ControladorEmpleado {

    @Autowired
    private ServicioEmpleado servicio;

    @PostMapping
    public ResponseEntity<ModeloEmpleado> registrar(@Valid @RequestBody EmpleadoDTO dto) {
        return new ResponseEntity<>(servicio.contratar(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModeloEmpleado>> listar() {
        return ResponseEntity.ok(servicio.listarActivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloEmpleado> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.obtenerPorId(id));
    }
}