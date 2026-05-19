package com.e_commerce.ms_usuarios.Controlador;

import com.e_commerce.ms_usuarios.DTO.UsuarioDTO;
import com.e_commerce.ms_usuarios.Modelo.ModeloUsuario;
import com.e_commerce.ms_usuarios.Servicio.ServicioUsuario;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    @Autowired
    private ServicioUsuario service;

    // http://localhost:8091/api/usuarios/guardar
    @PostMapping("/guardar")
    public ResponseEntity<ModeloUsuario> crear(@Valid @RequestBody UsuarioDTO dto) {
        log.info("Petición POST recibida para registrar credenciales del email: {}", dto.getEmail());
        ModeloUsuario nuevoUsuario = service.guardarUsuario(dto);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    //  http://localhost:8091/api/usuarios/todos
    @GetMapping("/todos")
    public ResponseEntity<List<ModeloUsuario>> listar() {
        log.info("Petición GET recibida para listar todas las cuentas de usuario");
        return ResponseEntity.ok(service.obtenerTodos());
    }

    // http://localhost:8091/api/usuarios/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ModeloUsuario> buscarPorId(@PathVariable("id") Long id) {
        log.info("Petición GET recibida para buscar usuario con ID: {}", id);
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    // http://localhost:8091/api/usuarios/filtrar/rol/{rol}
    @GetMapping("/filtrar/rol/{rol}")
    public ResponseEntity<List<ModeloUsuario>> filtrarPorRol(@PathVariable("rol") String rol) {
        log.info("Petición GET recibida para filtrar usuarios bajo el rol: {}", rol);
        return ResponseEntity.ok(service.listarPorRol(rol));
    }
    // http://localhost:8091/api/usuarios/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<java.util.Map<String, String>> eliminar(@PathVariable("id") Long id) {
        log.info("Petición DELETE recibida para remover el usuario ID: {}", id);
        service.eliminarUsuario(id);

        java.util.Map<String, String> respuesta = new java.util.HashMap<>();
        respuesta.put("mensaje", "El usuario ha sido eliminado correctamente del sistema.");
        return ResponseEntity.ok(respuesta);
    }
    //http://localhost:8091/api/usuarios/{id}
    @PutMapping("/{id}")
    public ResponseEntity<ModeloUsuario> actualizar(@PathVariable("id") Long id, @Valid @RequestBody UsuarioDTO dto) {
        log.info("Petición PUT recibida para modificar el usuario ID: {}", id);
        ModeloUsuario usuarioEditado = service.actualizarUsuario(id, dto);
        return ResponseEntity.ok(usuarioEditado);
    }
}