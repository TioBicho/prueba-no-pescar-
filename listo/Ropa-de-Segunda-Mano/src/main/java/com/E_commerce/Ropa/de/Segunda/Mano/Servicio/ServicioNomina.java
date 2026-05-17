package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.Prenda;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.PrendaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class PrendaService {

    @Autowired
    private PrendaRepository repository;

    public Prenda guardarPrenda(Prenda prenda) {
        log.info("Agregando nueva prenda al catálogo: {} - {}", prenda.getNombre(), prenda.getTipo());
        return repository.save(prenda);
    }

    public List<Prenda> listarTodo() {
        log.info("Consultando catálogo completo de prendas");
        return repository.findAll();
    }

    public Prenda obtenerPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> {
                log.error("Error: Prenda con ID {} no encontrada", id);
                return new RuntimeException("Prenda no encontrada");
            });
    }
}