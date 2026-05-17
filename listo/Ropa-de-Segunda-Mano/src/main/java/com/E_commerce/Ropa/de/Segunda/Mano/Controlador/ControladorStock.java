package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.StockDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Stock;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.StockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class ControladorStock {

    @Autowired
    private StockService service;

    @PostMapping("/actualizar")
    public ResponseEntity<Stock> actualizar(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.actualizarInventario(dto));
    }

    @PutMapping("/descontar/{id}")
    public ResponseEntity<String> descontar(@PathVariable Long id, @RequestParam Integer cantidad) {
        service.descontarStock(id, cantidad);
        return ResponseEntity.ok("Stock actualizado correctamente");
    }
}