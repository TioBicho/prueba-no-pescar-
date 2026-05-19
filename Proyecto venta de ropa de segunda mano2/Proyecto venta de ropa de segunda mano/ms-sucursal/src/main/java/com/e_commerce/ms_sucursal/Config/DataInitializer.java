package com.e_commerce.ms_sucursal.Config;

import com.e_commerce.ms_sucursal.Modelo.ModeloSucursal;
import com.e_commerce.ms_sucursal.Repositorio.RepositorioSucursal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {


    private final RepositorioSucursal repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de sucursales...");


        if (repository.count() > 0) {
            log.info(">>> Sucursales ya detectadas en el sistema. Se omite inicialización.");
            return;
        }

        log.info(">>> Base de datos de sucursales vacía. Insertando sedes iniciales...");


        ModeloSucursal suc1 = new ModeloSucursal();
        suc1.setNombreSucursal("Suc. Viña");
        suc1.setCiudad("Viña del Mar");
        suc1.setRegionId(5L);


        ModeloSucursal suc2 = new ModeloSucursal();
        suc2.setNombreSucursal("Suc. S.Felipe");
        suc2.setCiudad("San Felipe");
        suc2.setRegionId(5L);

        repository.save(suc1);
        repository.save(suc2);

        log.info(">>> 2 sucursales cargadas con éxito. ID 1 y 2 listos para ser usados por empleados.");
    }
}