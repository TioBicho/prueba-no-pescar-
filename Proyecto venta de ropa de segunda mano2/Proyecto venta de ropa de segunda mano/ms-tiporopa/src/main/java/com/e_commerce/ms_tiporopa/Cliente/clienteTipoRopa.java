package com.e_commerce.ms_tiporopa.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-categorias", path = "/api/categorias")
public interface clienteTipoRopa {

    @GetMapping("/{id}")
    String verificarCategoriaExiste(@PathVariable("id") Long id);
}