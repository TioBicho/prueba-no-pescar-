package com.e_commerce.ms_detalleventas.Cliente;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-ventas", path = "/api/ventas")
public interface detalleVentaClient {


    @GetMapping("/{id}")
    String verificarVentaExiste(@PathVariable("id") Long id);
}