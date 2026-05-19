package com.e_commerce.ms_empleados.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios", path = "/api/usuarios")
public interface UsuarioCliente {

    @GetMapping("/{id}")
    Object obtenerUsuarioPorId(@PathVariable("id") Long id);
}