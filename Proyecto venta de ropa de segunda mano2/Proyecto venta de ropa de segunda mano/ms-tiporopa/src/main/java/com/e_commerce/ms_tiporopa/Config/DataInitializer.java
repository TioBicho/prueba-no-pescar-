package com.e_commerce.ms_tiporopa.Config;

import com.e_commerce.ms_tiporopa.Modelo.ModeloTipoRopa;
import com.e_commerce.ms_tiporopa.Repositorio.RepositorioTipoRopa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RepositorioTipoRopa repositorio;

    @Override
    public void run(String... args) throws Exception {
        if (repositorio.count() == 0) {
            log.info("Base de datos vacía en Tipo_ropa. Insertando datos de prueba...");
            //Polera Deportiva
            ModeloTipoRopa tipo1 = new ModeloTipoRopa();
            tipo1.setDiseno("D");
            tipo1.setEstilo("Deportivo");
            tipo1.setColor("Negro");
            tipo1.setComposicion("100% Poliéster");
            tipo1.setDetalles("Manga corta run");
            tipo1.setTipoPrenda("Polera");
            tipo1.setGenero("Unisex");
            tipo1.setTalla("L");
            tipo1.setMarca("Nike");
            tipo1.setEstadoPrenda("Nuevo");
            tipo1.setCategoriaId(1L);

            // Jean Casual
            ModeloTipoRopa tipo2 = new ModeloTipoRopa();
            tipo2.setDiseno("C");
            tipo2.setEstilo("Casual");
            tipo2.setColor("Azul Mezclilla");
            tipo2.setComposicion("98% Algodón, 2% Elastano");
            tipo2.setDetalles("Slim Fit");
            tipo2.setTipoPrenda("Pantalón");
            tipo2.setGenero("Hombre");
            tipo2.setTalla("42");
            tipo2.setMarca("Levi's");
            tipo2.setEstadoPrenda("Nuevo");
            tipo2.setCategoriaId(1L);

            repositorio.save(tipo1);
            repositorio.save(tipo2);

            log.info("¡Datos de prueba para Tipo de Ropa inicializados con éxito!");
        } else {
            log.info("La tabla Tipo_ropa ya cuenta con registros. No se requiere inicialización.");
        }
    }
}