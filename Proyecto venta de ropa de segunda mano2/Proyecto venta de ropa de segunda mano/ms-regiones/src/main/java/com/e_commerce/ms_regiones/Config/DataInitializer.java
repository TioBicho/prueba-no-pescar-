package com.e_commerce.ms_regiones.Config;

import com.e_commerce.ms_regiones.Modelo.ModeloRegion;
import com.e_commerce.ms_regiones.Repositorio.RepositorioRegion;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RepositorioRegion repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de regiones...");


        if (repository.count() > 0) {
            log.info(">>> Regiones ya detectadas en el sistema. Se omite la inicialización.");
            return;
        }

        log.info(">>> Base de datos de regiones vacía. Insertando zonas iniciales de Chile...");



        ModeloRegion reg1 = new ModeloRegion();
        reg1.setNombreRegion("Tarapacá"); // ID 1
        repository.save(reg1);

        ModeloRegion reg2 = new ModeloRegion();
        reg2.setNombreRegion("Antofagasta"); // ID 2
        repository.save(reg2);

        ModeloRegion reg3 = new ModeloRegion();
        reg3.setNombreRegion("Atacama"); // ID 3
        repository.save(reg3);

        ModeloRegion reg4 = new ModeloRegion();
        reg4.setNombreRegion("Coquimbo"); // ID 4
        repository.save(reg4);


        ModeloRegion reg5 = new ModeloRegion();
        reg5.setNombreRegion("Valparaíso"); // ID 5
        repository.save(reg5);

        log.info(">>> 5 regiones cargadas con éxito. Región ID 5 ('Valparaíso') lista para enlazar sucursales.");
    }
}