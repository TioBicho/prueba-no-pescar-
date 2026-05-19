package com.e_commerce.ms_prendas.Config;

import com.e_commerce.ms_prendas.Modelo.ModeloPrenda;
import com.e_commerce.ms_prendas.Repositorio.RepositorioPrenda;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RepositorioPrenda repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            log.info("Base de datos vacía en Ropa. Inicializando prendas de prueba con SKUs...");

            // Polera Nike
            ModeloPrenda prenda1 = new ModeloPrenda();
            prenda1.setId("POL01NKL");
            prenda1.setDescripcion("Polera Nike Running Negra Talla L");
            prenda1.setCuidados("Lavar con agua fria");
            prenda1.setTipoRopaId(1L);

            // Jeans Levi's
            ModeloPrenda prenda2 = new ModeloPrenda();
            prenda2.setId("JNS42LVS");
            prenda2.setDescripcion("Pantalón Levi's Slim Fit Talla 42");
            prenda2.setCuidados("Lavar a mano");
            prenda2.setTipoRopaId(2L);
            repository.save(prenda1);
            repository.save(prenda2);

            log.info("¡Datos de prueba de prendas (SKUs) guardados correctamente!");
        } else {
            log.info("La tabla Ropa ya contiene registros. Saltando inicialización.");
        }
    }
}