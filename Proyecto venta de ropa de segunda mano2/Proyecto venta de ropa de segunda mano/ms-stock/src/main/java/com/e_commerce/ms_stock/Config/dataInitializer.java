package com.e_commerce.ms_stock.Config;

import com.e_commerce.ms_stock.Modelo.ModeloStock;
import com.e_commerce.ms_stock.Repositorio.RepositorioStock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class dataInitializer implements CommandLineRunner {


    private final RepositorioStock repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Verificando el estado del inventario de stock...");


        if (repository.count() > 0) {
            log.info(">>> Inventario de stock ya detectado. Se omite inicialización.");
            return;
        }

        log.info(">>> Almacén de stock vacío. Insertando existencias base de ropa...");


        ModeloStock stock1 = new ModeloStock();
        stock1.setCantidad(45);
        stock1.setEstadoInventario("DISPONIBLE");
        stock1.setRopaIdRopa("POL01NKL");
        stock1.setSucursalIdSucursal(1L);



        ModeloStock stock2 = new ModeloStock();
        stock2.setCantidad(8);
        stock2.setEstadoInventario("ULTIMAS UNIDADES");
        stock2.setRopaIdRopa("JNS42LVS");
        stock2.setSucursalIdSucursal(2L);


        repository.save(stock1);
        repository.save(stock2);

        log.info(">>> Existencias base de stock cargadas con éxito");

        log.info(">>> 2 registros de inventario inicializados con éxito en Oracle Cloud.");
    }
}