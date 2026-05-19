package com.e_commerce.ms_detalleventas.Controlador;

import com.e_commerce.ms_detalleventas.DTO.DetalleVentaDTO;
import com.e_commerce.ms_detalleventas.Modelo.ModeloDetalleVenta;
import com.e_commerce.ms_detalleventas.Servicio.ServicioDetalleVenta;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/detalleventas")
public class ControladorDetalleVenta {

    @Autowired
    private ServicioDetalleVenta service;

    // http://localhost:8082/api/detalleventas/guardar
    @PostMapping("/guardar")
    public ResponseEntity<ModeloDetalleVenta> crear(@Valid @RequestBody DetalleVentaDTO dto) {
        log.info("Petición POST recibida para crear línea de detalle. SKU Prenda: {}, Venta ID: {}",
                dto.getRopaId(), dto.getVentaId());
        ModeloDetalleVenta nuevoDetalle = service.guardarConDTO(dto);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    // http://localhost:8082/api/detalleventas/todas
    @GetMapping("/todas")
    public ResponseEntity<List<ModeloDetalleVenta>> listar() {
        log.info("Petición GET recibida para listar el historial de detalles de ventas");
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // http://localhost:8082/api/detalleventas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ModeloDetalleVenta> buscar(@PathVariable("id") Long id) {
        log.info("Petición GET recibida para buscar detalle de venta con ID: {}", id);
        return ResponseEntity.ok(service.obtenerPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ModeloDetalleVenta> actualizar(@PathVariable Long id, @Valid @RequestBody DetalleVentaDTO dto) {
        log.info("Petición PUT: Modificando montos de la línea de detalle ID: {}", id);
        return ResponseEntity.ok(service.actualizarDetalle(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable Long id) {
        log.info("Petición DELETE: Quitando línea de detalle ID: {}", id);
        service.eliminarDetalle(id);
        Map<String, String> resp = new HashMap<>();
        resp.put("mensaje", "El ítem fue removido de la boleta de venta.");
        return ResponseEntity.ok(resp);
    }
}