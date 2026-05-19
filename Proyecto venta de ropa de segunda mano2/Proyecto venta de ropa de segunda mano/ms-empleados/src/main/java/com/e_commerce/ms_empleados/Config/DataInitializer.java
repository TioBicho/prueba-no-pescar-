package com.e_commerce.ms_empleados.Config;

import com.e_commerce.ms_empleados.Modelo.ModeloEmpleados;
import com.e_commerce.ms_empleados.Repositorio.RepositorioEmpleado;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RepositorioEmpleado repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de empleados...");

        if (repository.count() > 0) {
            log.info(">>> Empleados ya cargados en el sistema. Se omite inicialización.");
            return;
        }

        log.info(">>> Base de datos de empleados vacía. Insertando personal inicial...");

        ModeloEmpleados emp1 = new ModeloEmpleados();

        emp1.setRun(11111111);
        emp1.setDv("1");
        emp1.setNombre("Juan");
        emp1.setApellidoPaterno("Pérez");
        emp1.setApellidoMaterno("Gómez");
        emp1.setFechaContrato(java.time.LocalDate.now());
        emp1.setCargo("VENDEDOR");
        emp1.setUsuarioId(1L);
        emp1.setSucursalId(1L);

        ModeloEmpleados emp2 = new ModeloEmpleados();

        emp2.setRun(22222222);
        emp2.setDv("2");
        emp2.setNombre("María");
        emp2.setApellidoPaterno("Inés");
        emp2.setApellidoMaterno("Soto");
        emp2.setFechaContrato(java.time.LocalDate.now());
        emp2.setCargo("CAJERO");

        emp2.setUsuarioId(2L);
        emp2.setSucursalId(1L);

        repository.save(emp1);
        repository.save(emp2);

        repository.save(emp1);
        repository.save(emp2);

        log.info(">>> 2 empleados cargados correctamente (IDs 1 y 2 listos para vincular ventas).");
    }
}