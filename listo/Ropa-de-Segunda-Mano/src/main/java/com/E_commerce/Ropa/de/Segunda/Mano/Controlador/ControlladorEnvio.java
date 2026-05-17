package com.E_commerce.Ropa.de.Segunda.Mano.Controlador;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.EnvioDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEnvio;
import com.E_commerce.Ropa.de.Segunda.Mano.Servicio.ServicioEnvio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/envios")
public class ControladorEnvio {

    @Autowired
    private ServicioEnvio servicio;

    @PostMapping
    public ResponseEntity<ModeloEnvio> registrarEnvio(@Valid @RequestBody EnvioDTO dto) {
        log.info("Petición recibida para generar despacho");
        return new ResponseEntity<>(servicio.crearEnvio(dto), HttpStatus.CREATED);
    }
}