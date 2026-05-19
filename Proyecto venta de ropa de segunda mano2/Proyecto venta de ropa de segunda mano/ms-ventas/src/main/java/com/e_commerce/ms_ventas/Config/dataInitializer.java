package com.e_commerce.ms_ventas.Config;

import com.e_commerce.ms_ventas.Modelo.ModeloVentas;
import com.e_commerce.ms_ventas.Repositorio.RepositorioVentas;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {


    private final RepositorioVentas repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de ventas...");

        if (repository.count() > 0) {
            log.info(">>> Ventas ya cargadas. Se omite inicialización.");
            return;
        }

        log.info(">>> Cargando ventas iniciales...");


        ModeloVentas venta1 = new ModeloVentas();
        venta1.setBoleta("BOL-2026-0001");
        venta1.setCarrito(101);
        venta1.setClienteRut(12345678); // RUT de prueba
        venta1.setEmpleadoId(4L);


        ModeloVentas venta2 = new ModeloVentas();
        venta2.setBoleta("BOL-2026-0002");
        venta2.setCarrito(102);
        venta2.setClienteRut(18765432);
        venta2.setEmpleadoId(5L);


        repository.save(venta1);
        repository.save(venta2);

        log.info(">>> 2 ventas cargadas OK.");
    }
}