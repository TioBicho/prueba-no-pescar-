package com.e_commerce.ms_envios.Config;

import com.e_commerce.ms_envios.Modelo.ModeloEnvios;
import com.e_commerce.ms_envios.Repositorio.RepositorioEnvios;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {


    private final RepositorioEnvios repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de envíos...");


        if (repository.count() > 0) {
            log.info(">>> Envíos ya detectados en el sistema. Se omite la inicialización.");
            return;
        }

        log.info(">>> Base de datos de envíos vacía. Insertando despachos de prueba...");


        ModeloEnvios env1 = new ModeloEnvios();
        env1.setDireccionDestino("Av. Libertad 1234, Viña del Mar");
        env1.setTransportista("Starken");
        env1.setNumeroSeguimiento("STK-99881122");
        env1.setEstado("EN CAMINO");
        env1.setFechaCreacion(LocalDate.now());
        env1.setVentasIdVenta(29L);


        ModeloEnvios env2 = new ModeloEnvios();
        env2.setDireccionDestino("Arturo Prat 567, San Felipe");
        env2.setTransportista("Chilexpress");
        env2.setNumeroSeguimiento("CHX-55443322");
        env2.setEstado("ENTREGADO");
        env2.setFechaCreacion(LocalDate.now().minusDays(2));
        env2.setVentasIdVenta(30L);

        repository.save(env1);
        repository.save(env2);

        log.info(">>> Despachos de prueba inicializados con éxito.");
        log.info(">>> 2 envíos de prueba inicializados correctamente (Asociados a Ventas 1 y 2).");
    }
}