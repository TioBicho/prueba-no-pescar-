package com.E_commerce.Ropa.de.Segunda.Mano.Servicio;

import com.E_commerce.Ropa.de.Segunda.Mano.DTO.EmpleadoDTO;
import com.E_commerce.Ropa.de.Segunda.Mano.Modelo.ModeloEmpleado;
import com.E_commerce.Ropa.de.Segunda.Mano.Repositorio.RepositorioEmpleado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class ServicioEmpleado {

    @Autowired
    private RepositorioEmpleado repositorio;

    public ModeloEmpleado contratar(EmpleadoDTO dto) {
        log.info("Registrando nuevo empleado: {}", dto.getNombre());
        
        ModeloEmpleado empleado = new ModeloEmpleado();
        empleado.setRut(dto.getRut());
        empleado.setNombre(dto.getNombre());
        empleado.setCargo(dto.getCargo());
        empleado.setSalarioBase(dto.getSalarioBase());
        empleado.setEmail(dto.getEmail());
        
        return repositorio.save(empleado);
    }

    public List<ModeloEmpleado> listarActivos() {
        log.info("Consultando lista de empleados");
        return repositorio.findAll();
    }

    public ModeloEmpleado obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }
}