package com.e_commerce.ms_perfil.Config;

import com.e_commerce.ms_perfil.Modelo.ModeloPerfil;
import com.e_commerce.ms_perfil.Repositorio.RepositorioPerfil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {

    private final RepositorioPerfil repository;

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            log.info("Poblando tabla PERFIL con números telefónicos de prueba...");

            ModeloPerfil p1 = new ModeloPerfil(null, "+56911112222");
            ModeloPerfil p2 = new ModeloPerfil(null, "+56933334444");
            ModeloPerfil p3 = new ModeloPerfil(null, "+56955556666");

            repository.saveAll(List.of(p1, p2, p3));
            log.info("¡Poblado de datos inicial para perfiles cerrado!");
        }
    }
}