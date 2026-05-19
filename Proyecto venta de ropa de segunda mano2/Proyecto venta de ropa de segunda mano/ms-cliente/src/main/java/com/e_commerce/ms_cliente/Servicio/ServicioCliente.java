package com.e_commerce.ms_cliente.Servicio;

import com.e_commerce.ms_cliente.DTO.ClienteDTO;
import com.e_commerce.ms_cliente.Modelo.ModeloCliente;
import com.e_commerce.ms_cliente.Repositorio.RepositorioCliente;
import com.e_commerce.ms_cliente.Repositorio.RepositorioTipoCliente;
import com.e_commerce.ms_cliente.Cliente.UsuarioClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicioCliente {

    private final RepositorioCliente repositorioCliente;
    private final RepositorioTipoCliente repositorioTipoCliente;


    private final UsuarioClient usuarioClient;

    public ModeloCliente guardar(ClienteDTO dto) {
        log.info("Registrando nuevo cliente: {}", dto.getNombreCliente());


        repositorioTipoCliente.findById(dto.getTipoClienteId())
                .orElseThrow(() -> new RuntimeException("El Tipo de Cliente con ID " + dto.getTipoClienteId() + " no existe."));


        try {
            log.info("Consultando vía Feign al ms-usuarios por el ID: {}", dto.getUsuarioIdUsuario());
            usuarioClient.obtenerPorId(dto.getUsuarioIdUsuario()); // 🔥 Llamada externa
        } catch (Exception e) {
            // Si ms-usuarios responde con un 404 o está apagado, saltará al catch
            throw new RuntimeException("Error de vinculación: El Usuario con ID " + dto.getUsuarioIdUsuario() + " no existe en el sistema global.");
        }


        ModeloCliente cliente = new ModeloCliente();
        cliente.setRut(dto.getRut());
        cliente.setDv(dto.getDv());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setPapellido(dto.getPapellido());
        cliente.setMapellido(dto.getMapellido());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        cliente.setTipoClienteId(dto.getTipoClienteId());
        cliente.setUsuarioIdUsuario(dto.getUsuarioIdUsuario());

        return repositorioCliente.save(cliente);
    }


    public List<ModeloCliente> obtenerTodos() {
        log.info("Recuperando listado global de clientes.");
        return repositorioCliente.findAll();
    }


    public ModeloCliente obtenerPorRut(Long rut) {
        log.info("Buscando cliente con RUT: {}", rut);
        return repositorioCliente.findById(rut)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con el RUT: " + rut));
    }



    public ModeloCliente actualizarCliente(Long id, ClienteDTO dto) {
        log.info("Actualizando datos del cliente con ID: {}", id);

        ModeloCliente cliente = repositorioCliente.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el cliente con ID: " + id));

        repositorioTipoCliente.findById(dto.getTipoClienteId())
                .orElseThrow(() -> new RuntimeException("Error de actualización: El Tipo de Cliente con ID " + dto.getTipoClienteId() + " no existe."));


        cliente.setRut(dto.getRut());
        cliente.setDv(dto.getDv());
        cliente.setNombreCliente(dto.getNombreCliente());
        cliente.setPapellido(dto.getPapellido());
        cliente.setMapellido(dto.getMapellido());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        cliente.setTipoClienteId(dto.getTipoClienteId());
        cliente.setUsuarioIdUsuario(dto.getUsuarioIdUsuario());

        return repositorioCliente.save(cliente);
    }

    public void eliminarCliente(Long id) {
        log.info("Intentando eliminar cliente con ID: {}", id);

        ModeloCliente cliente = repositorioCliente.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar: El cliente con ID " + id + " no existe en el sistema."));

        repositorioCliente.delete(cliente);
        log.info("¡Cliente con ID {} eliminado exitosamente!", id);
    }


    public List<ModeloCliente> buscarClientesPorNombre(String keyword) {
        log.info("Filtrando clientes por coincidencia de nombre: '{}'", keyword);
        return repositorioCliente.buscarPorNombreClave(keyword);
    }



}