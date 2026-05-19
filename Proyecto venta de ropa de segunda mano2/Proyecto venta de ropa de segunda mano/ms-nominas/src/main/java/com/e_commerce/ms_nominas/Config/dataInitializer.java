package com.e_commerce.ms_nominas.Config;

import com.e_commerce.ms_nominas.Modelo.ModeloNomina;
import com.e_commerce.ms_nominas.Repositorio.RepositorioNomina;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {

    private final RepositorioNomina repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de nóminas...");


        if (repository.count() > 0) {
            log.info(">>> Nóminas ya detectadas en el sistema. Se omite la inicialización.");
            return;
        }

        log.info(">>> Base de datos de nóminas vacía. Insertando planillas iniciales...");

        ModeloNomina nom1 = new ModeloNomina();
        nom1.setSueldoBase(650000L);
        nom1.setBonos(80000L);
        nom1.setDescuentos(45000L);
        nom1.setSueldoLiquido(685000L);
        nom1.setFechaEmision(LocalDate.now().minusMonths(1));
        nom1.setEmpleadoId(4L);


        ModeloNomina nom2 = new ModeloNomina();
        nom2.setSueldoBase(850000L);
        nom2.setBonos(120000L);
        nom2.setDescuentos(65000L);
        nom2.setSueldoLiquido(905000L);
        nom2.setFechaEmision(LocalDate.now());
        nom2.setEmpleadoId(5L);

        repository.save(nom1);
        repository.save(nom2);
        log.info(">>> 2 nóminas del personal inicializadas correctamente en la nube.");
    }
}