package com.e_commerce.ms_cliente.Config;

import com.e_commerce.ms_cliente.Modelo.ModeloCliente;
import com.e_commerce.ms_cliente.Repositorio.RepositorioCliente;
import com.e_commerce.ms_cliente.Modelo.ModeloTipoCliente;
import com.e_commerce.ms_cliente.Repositorio.RepositorioTipoCliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor // 🚀 Inyecta automáticamente ambos repositorios final por constructor
public class datainitializer implements CommandLineRunner {

    private final RepositorioCliente clienteRepository;
    private final RepositorioTipoCliente tipoClienteRepository;

    @Override
    public void run(String... args) throws Exception {

        // 🗼 BLOQUE 1: Pre-poblar TIPO_CLIENTE (¡Obligatorio que vaya primero!)
        log.info("Verificando estado de la tabla TIPO_CLIENTE en Oracle Cloud...");

        if (tipoClienteRepository.count() == 0) {
            log.info("La tabla TIPO_CLIENTE está vacía. Pre-poblando categorías estructurales de cliente...");

            ModeloTipoCliente regular = new ModeloTipoCliente(null, "Regular", LocalDate.now(), 0);
            ModeloTipoCliente premium = new ModeloTipoCliente(null, "Premium", LocalDate.now(), 500);
            ModeloTipoCliente vip = new ModeloTipoCliente(null, "VIP", LocalDate.now(), 1500);

            tipoClienteRepository.saveAll(List.of(regular, premium, vip));
            log.info("¡Poblado inicial completado con éxito! 3 categorías añadidas al catálogo.");
        } else {
            log.info("La tabla TIPO_CLIENTE ya cuenta con registros activos. Saltando inicialización.");
        }

        // 👥 BLOQUE 2: Pre-poblar CLIENTE (Corre inmediatamente después)
        log.info("Monitoreando estado de la tabla CLIENTE en Oracle Cloud...");

        if (clienteRepository.count() == 0) {
            log.info("No se encontraron registros de clientes. Generando inserciones iniciales...");

            ModeloCliente cliente1 = new ModeloCliente();
            cliente1.setRut(12345678L);
            cliente1.setDv(5);
            cliente1.setNombreCliente("Juan");
            cliente1.setFechaNacimiento(LocalDate.of(1995, 4, 12));
            cliente1.setPapellido("Pérez");
            cliente1.setMapellido("Muñoz");
            cliente1.setTipoClienteId(1L); // 🌟 Se amarra correctamente a "Regular" (ID 1)
            cliente1.setUsuarioIdUsuario(1L);

            ModeloCliente cliente2 = new ModeloCliente();
            cliente2.setRut(18765432L);
            cliente2.setDv(1);
            cliente2.setNombreCliente("María");
            cliente2.setFechaNacimiento(LocalDate.of(1998, 11, 23));
            cliente2.setPapellido("Rojas");
            cliente2.setMapellido("Silva");
            cliente2.setTipoClienteId(2L); // 🌟 Se amarra correctamente a "Premium" (ID 2)
            cliente2.setUsuarioIdUsuario(2L);

            clienteRepository.saveAll(List.of(cliente1, cliente2));
            log.info("¡Pre-poblado de la tabla CLIENTE finalizado con éxito! 2 registros agregados.");
        } else {
            log.info("La tabla CLIENTE ya cuenta con registros activos. Omitiendo datos de prueba.");
        }
    }
}