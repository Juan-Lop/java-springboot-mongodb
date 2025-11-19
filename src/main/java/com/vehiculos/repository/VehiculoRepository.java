package com.vehiculos.repository;

import com.vehiculos.model.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
    
    // Buscar por placa
    Optional<Vehiculo> findByPlaca(String placa);
    
    // Verificar si existe por placa
    boolean existsByPlaca(String placa);
}
