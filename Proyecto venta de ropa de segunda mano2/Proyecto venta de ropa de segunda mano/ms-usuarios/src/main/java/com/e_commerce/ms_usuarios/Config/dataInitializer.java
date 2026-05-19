package com.e_commerce.ms_usuarios.Config;

import com.e_commerce.ms_usuarios.Modelo.ModeloUsuario;
import com.e_commerce.ms_usuarios.Repositorio.RepositorioUsuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {

    private final RepositorioUsuario repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado de la base de datos de usuarios...");

        if (repository.count() > 0) {
            log.info(">>> Usuarios ya detectados en el sistema. Se omite la inicialización.");
            return;
        }

        log.info(">>> Base de datos de usuarios vacía. Insertando cuentas iniciales de prueba...");


        ModeloUsuario user1 = new ModeloUsuario();
        user1.setEmail("admin@test.cl");
        user1.setPassword("Admin2026");
        user1.setRol("ADMIN");
        user1.setPerfilIdPerfil(1L);

        ModeloUsuario user2 = new ModeloUsuario();
        user2.setEmail("soporte@test.com");
        user2.setPassword("Soporte2026");
        user2.setRol("EMPLEADO");
        user2.setPerfilIdPerfil(2L);

        repository.save(user1);
        repository.save(user2);

        log.info(">>> 2 usuarios base inyectados correctamente (Roles: ADMIN y EMPLEADO).");
    }
}