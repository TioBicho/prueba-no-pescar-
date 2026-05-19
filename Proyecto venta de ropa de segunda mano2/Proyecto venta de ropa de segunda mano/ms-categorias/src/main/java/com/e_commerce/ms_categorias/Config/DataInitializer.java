package com.e_commerce.ms_categorias.Config;

import com.e_commerce.ms_categorias.Modelo.ModeloCategoria;
import com.e_commerce.ms_categorias.Repositorio.RepositorioCategoria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RepositorioCategoria repositorioCategoria;

    @Override
    public void run(String... args) throws Exception {


        if (repositorioCategoria.count() == 0) {
            log.info(">>> La tabla de categorías está vacía. Sembrando datos iniciales...");

            ModeloCategoria cat1 = new ModeloCategoria();
            cat1.setNombre("Poleras");
            repositorioCategoria.save(cat1);

            ModeloCategoria cat2 = new ModeloCategoria();
            cat2.setNombre("Pantalones");
            repositorioCategoria.save(cat2);

            ModeloCategoria cat3 = new ModeloCategoria();
            cat3.setNombre("Chaquetas");
            repositorioCategoria.save(cat3);

            log.info(">>> 3 Categorías base cargadas con éxito en Oracle Cloud.");
        } else {
            log.info(">>> La tabla ya cuenta con categorías registradas. Se omite la siembra.");
        }
    }
}