package com.e_commerce.ms_empleados.Cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ms-sucursal", path= "api/sucursales")
public interface SucursalCliente {

    @GetMapping("/{id}")
    Object obtenerPorId(@PathVariable("id") Long id);
}