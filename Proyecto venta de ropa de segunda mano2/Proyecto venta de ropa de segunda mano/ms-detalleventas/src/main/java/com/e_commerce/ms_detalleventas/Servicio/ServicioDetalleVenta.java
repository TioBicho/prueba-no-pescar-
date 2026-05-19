package com.e_commerce.ms_detalleventas.Servicio;

import com.e_commerce.ms_detalleventas.Cliente.DetalleClient;
import com.e_commerce.ms_detalleventas.Cliente.detalleVentaClient;
import com.e_commerce.ms_detalleventas.DTO.DetalleVentaDTO;
import com.e_commerce.ms_detalleventas.Modelo.ModeloDetalleVenta;
import com.e_commerce.ms_detalleventas.Repositorio.RepositorioDetalleVenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServicioDetalleVenta {

    @Autowired
    private RepositorioDetalleVenta repository;

    @Autowired
    private DetalleClient prendaClient;

    @Autowired
    private detalleVentaClient ventaClient;

    public ModeloDetalleVenta guardarConDTO(DetalleVentaDTO dto) {
        log.info("Iniciando validaciones para el detalle de venta. SKU Prenda: {}", dto.getRopaId());

        if (dto.getDescuentoAplicado() > dto.getPrecioOriginal()) {
            log.error("Error de consistencia: El descuento (${}) supera al precio original (${})",
                    dto.getDescuentoAplicado(), dto.getPrecioOriginal());
            throw new RuntimeException("No se puede registrar el detalle: El descuento aplicado no puede ser mayor que el precio original de la prenda.");
        }


        try {
            prendaClient.verificarPrendaExiste(dto.getRopaId());
            log.info("Prenda verificada con éxito en ms-prendas. Registrando línea de detalle.");
        } catch (Exception e) {
            log.error("Error: La prenda con SKU {} no existe en el catálogo central.", dto.getRopaId());
            throw new RuntimeException("No se puede registrar el detalle: El código de ropa (SKU) ingresado no existe.");
        }
        try {
            ventaClient.verificarVentaExiste(dto.getVentaId());
            log.info("Cabecera de venta verificada con éxito en ms-ventas. Procediendo a registrar el detalle.");
        } catch (Exception e) {
            log.error("Error: La venta con ID {} no existe en el sistema.", dto.getVentaId());
            throw new RuntimeException("No se puede registrar el detalle: La boleta de venta (ventaId) ingresada no existe.");
        }

        ModeloDetalleVenta entidad = new ModeloDetalleVenta();
        entidad.setPrecioOriginal(dto.getPrecioOriginal());
        entidad.setDescuentoAplicado(dto.getDescuentoAplicado());
        entidad.setRopaId(dto.getRopaId());
        entidad.setVentaId(dto.getVentaId());

        return repository.save(entidad);
    }


    public List<ModeloDetalleVenta> obtenerTodos() {
        log.info("Consultando todos los detalles de venta registrados");
        return repository.findAll();
    }

    public ModeloDetalleVenta obtenerPorId(Long id) {
        log.info("Buscando detalle de venta con ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El detalle de venta con ID " + id + " no existe."));
    }
    public ModeloDetalleVenta actualizarDetalle(Long id, DetalleVentaDTO dto) {
        log.info("Modificando valores de la línea de detalle ID: {}", id);
        ModeloDetalleVenta detalle = obtenerPorId(id);
        try {

            ventaClient.verificarVentaExiste(dto.getVentaId());
            prendaClient.verificarPrendaExiste(dto.getRopaId());
        } catch (Exception e) {
            throw new RuntimeException("Error de Integridad: La Venta o la Prenda de ropa informada no existen.");
        }

        detalle.setPrecioOriginal(dto.getPrecioOriginal());
        detalle.setDescuentoAplicado(dto.getDescuentoAplicado());
        detalle.setRopaId(dto.getRopaId());
        detalle.setVentaId(dto.getVentaId());

        return repository.save(detalle);
    }

    public void eliminarDetalle(Long id) {
        log.info("Quitando línea de detalle ID: {}", id);
        ModeloDetalleVenta detalle = obtenerPorId(id);
        repository.delete(detalle);
    }
}