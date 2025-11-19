package com.vehiculos.service;

import com.vehiculos.exception.ResourceNotFoundException;
import com.vehiculos.exception.DuplicateResourceException;
import com.vehiculos.model.Vehiculo;
import com.vehiculos.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Obtener todos los vehículos
    public List<Vehiculo> obtenerTodos() {
        return vehiculoRepository.findAll();
    }

    // Obtener vehículo por ID
    public Vehiculo obtenerPorId(String id) {
        return vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con ID: " + id));
    }

    // Crear vehículo
    public Vehiculo crear(Vehiculo vehiculo) {
        // Verificar si la placa ya existe
        if (vehiculoRepository.existsByPlaca(vehiculo.getPlaca())) {
            throw new DuplicateResourceException("La placa " + vehiculo.getPlaca() + " ya existe en el sistema");
        }
        
        vehiculo.setCreatedAt(LocalDateTime.now());
        vehiculo.setUpdatedAt(LocalDateTime.now());
        return vehiculoRepository.save(vehiculo);
    }

    // Actualizar vehículo
    public Vehiculo actualizar(String id, Vehiculo vehiculoDetalles) {
        Vehiculo vehiculo = obtenerPorId(id);

        // Verificar si la placa ya existe (y no es del mismo vehículo)
        if (vehiculoDetalles.getPlaca() != null && 
            !vehiculoDetalles.getPlaca().equals(vehiculo.getPlaca()) &&
            vehiculoRepository.existsByPlaca(vehiculoDetalles.getPlaca())) {
            throw new DuplicateResourceException("La placa " + vehiculoDetalles.getPlaca() + " ya existe en el sistema");
        }

        // Actualizar campos
        if (vehiculoDetalles.getMarca() != null) vehiculo.setMarca(vehiculoDetalles.getMarca());
        if (vehiculoDetalles.getModelo() != null) vehiculo.setModelo(vehiculoDetalles.getModelo());
        if (vehiculoDetalles.getAño() != null) vehiculo.setAño(vehiculoDetalles.getAño());
        if (vehiculoDetalles.getColor() != null) vehiculo.setColor(vehiculoDetalles.getColor());
        if (vehiculoDetalles.getPlaca() != null) vehiculo.setPlaca(vehiculoDetalles.getPlaca());
        if (vehiculoDetalles.getPrecio() != null) vehiculo.setPrecio(vehiculoDetalles.getPrecio());
        if (vehiculoDetalles.getEstado() != null) vehiculo.setEstado(vehiculoDetalles.getEstado());

        vehiculo.setUpdatedAt(LocalDateTime.now());
        return vehiculoRepository.save(vehiculo);
    }

    // Eliminar vehículo
    public void eliminar(String id) {
        Vehiculo vehiculo = obtenerPorId(id);
        vehiculoRepository.delete(vehiculo);
    }
}
