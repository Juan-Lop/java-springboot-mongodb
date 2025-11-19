package com.vehiculos.controller;

import com.vehiculos.model.Vehiculo;
import com.vehiculos.service.VehiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // Endpoint raíz de bienvenida
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> bienvenida() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "🚗 API de Vehículos con Spring Boot");
        response.put("version", "1.0.0");
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("GET /api/vehiculos", "Obtener todos los vehículos");
        endpoints.put("GET /api/vehiculos/{id}", "Obtener un vehículo por ID");
        endpoints.put("POST /api/vehiculos", "Crear un nuevo vehículo");
        endpoints.put("PUT /api/vehiculos/{id}", "Actualizar un vehículo");
        endpoints.put("DELETE /api/vehiculos/{id}", "Eliminar un vehículo");
        
        response.put("endpoints", endpoints);
        return ResponseEntity.ok(response);
    }

    // GET - Obtener todos los vehículos
    @GetMapping
    public ResponseEntity<Map<String, Object>> obtenerTodos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodos();
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("count", vehiculos.size());
        response.put("data", vehiculos);
        
        return ResponseEntity.ok(response);
    }

    // GET - Obtener vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> obtenerPorId(@PathVariable String id) {
        Vehiculo vehiculo = vehiculoService.obtenerPorId(id);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", vehiculo);
        
        return ResponseEntity.ok(response);
    }

    // POST - Crear vehículo
    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@Valid @RequestBody Vehiculo vehiculo) {
        Vehiculo nuevoVehiculo = vehiculoService.crear(vehiculo);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Vehículo creado exitosamente");
        response.put("data", nuevoVehiculo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // PUT - Actualizar vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(
            @PathVariable String id,
            @RequestBody Vehiculo vehiculoDetalles) {
        
        Vehiculo vehiculoActualizado = vehiculoService.actualizar(id, vehiculoDetalles);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Vehículo actualizado exitosamente");
        response.put("data", vehiculoActualizado);
        
        return ResponseEntity.ok(response);
    }

    // DELETE - Eliminar vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable String id) {
        vehiculoService.eliminar(id);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Vehículo eliminado exitosamente");
        response.put("data", new HashMap<>());
        
        return ResponseEntity.ok(response);
    }
}
