package com.e_commerce.ms_usuarios.Servicio;

import com.e_commerce.ms_usuarios.Cliente.PerfilCliente;
import com.e_commerce.ms_usuarios.DTO.UsuarioDTO;
import com.e_commerce.ms_usuarios.Modelo.ModeloUsuario;
import com.e_commerce.ms_usuarios.Repositorio.RepositorioUsuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ServicioUsuario {

    @Autowired
    private RepositorioUsuario repository;
    @Autowired
    private PerfilCliente perfilFeignClient;

    public ModeloUsuario guardarUsuario(UsuarioDTO dto) {
        log.info("Iniciando evaluación de registro para el correo: {}", dto.getEmail());

        try {
            log.info("Verificando existencia del Perfil ID {} vía Feign...", dto.getPerfilIdPerfil());
            perfilFeignClient.obtenerPerfilPorId(dto.getPerfilIdPerfil()); // Método de tu interfaz Cliente
        } catch (Exception e) {
            log.error("Error Feign: El Perfil con ID {} no existe en el sistema.", dto.getPerfilIdPerfil());
            throw new RuntimeException("No se puede registrar el usuario: El Perfil informado no existe.");
        }

        if (repository.findByEmail(dto.getEmail()).isPresent()) {
            log.error("Validación local fallida: El email '{}' ya existe.", dto.getEmail());
            throw new RuntimeException("Ya existe una cuenta registrada con este correo electrónico.");
        }


        if (repository.findByPerfilIdPerfil(dto.getPerfilIdPerfil()).isPresent()) {
            log.error("Validación única fallida: El perfil ID {} ya posee un usuario.", dto.getPerfilIdPerfil());
            throw new RuntimeException("Operación denegada: Este perfil ya se encuentra asociado a otro usuario.");
        }


        ModeloUsuario entidad = new ModeloUsuario();
        entidad.setEmail(dto.getEmail());
        entidad.setPassword(dto.getPassword());
        entidad.setRol(dto.getRol());
        entidad.setPerfilIdPerfil(dto.getPerfilIdPerfil());

        log.info("Validaciones superadas con éxito. Registrando credenciales en Oracle Cloud.");
        return repository.save(entidad);
    }

    public List<ModeloUsuario> obtenerTodos() {
        log.info("Solicitando el listado general de usuarios de la plataforma.");
        return repository.findAll();
    }

    public ModeloUsuario obtenerPorId(Long id) {
        log.info("Buscando cuenta con ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El usuario con ID " + id + " no está registrado en el sistema."));
    }


    public List<ModeloUsuario> listarPorRol(String rol) {
        log.info("Filtrando cuentas bajo el rol operativo: {}", rol);
        return repository.buscarUsuariosPorRol(rol);
    }
    public void eliminarUsuario(Long id) {
        log.info("Iniciando proceso de eliminación para el usuario ID: {}", id);


        ModeloUsuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede eliminar: El usuario con ID " + id + " no existe."));

        repository.delete(usuario);
        log.info("Usuario ID {} eliminado exitosamente de Oracle Cloud.", id);
    }
    public ModeloUsuario actualizarUsuario(Long id, UsuarioDTO dto) {
        log.info("Iniciando proceso de actualización para el usuario ID: {}", id);

        ModeloUsuario usuarioActual = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se puede actualizar: El usuario con ID " + id + " no existe."));


        repository.findByEmail(dto.getEmail()).ifPresent(otroUsuario -> {
            if (!otroUsuario.getId().equals(id)) { // Si el ID es diferente, significa que es de otra persona
                log.error("Validación fallida: El email '{}' ya está ocupado por el usuario ID {}", dto.getEmail(), otroUsuario.getId());
                throw new RuntimeException("El correo electrónico informado ya se encuentra registrado en otra cuenta.");
            }
        });


        repository.findByPerfilIdPerfil(dto.getPerfilIdPerfil()).ifPresent(otroUsuario -> {
            if (!otroUsuario.getId().equals(id)) {
                log.error("Validación fallida: El perfil ID {} ya está asignado al usuario ID {}", dto.getPerfilIdPerfil(), otroUsuario.getId());
                throw new RuntimeException("El perfil informado ya está asociado a otro usuario del sistema.");
            }
        });


        usuarioActual.setEmail(dto.getEmail());
        usuarioActual.setPassword(dto.getPassword());
        usuarioActual.setRol(dto.getRol());
        usuarioActual.setPerfilIdPerfil(dto.getPerfilIdPerfil());

        log.info("Datos validados correctamente. Guardando actualización en Oracle Cloud.");
        return repository.save(usuarioActual);
    }
}