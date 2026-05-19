package com.e_commerce.ms_nominas.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-empleados", path = "/api/empleados")
public interface EmpleadoCliente {

    @GetMapping("/{id}")
    Object obtenerEmpleadoPorId(@PathVariable("id") Long id);
}