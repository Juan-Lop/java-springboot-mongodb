package com.vehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiVehiculosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiVehiculosApplication.class, args);
        System.out.println("\n🚀 API de Vehículos iniciada correctamente");
        System.out.println("📍 http://localhost:8080");
        System.out.println("📡 Endpoints disponibles en: http://localhost:8080/api/vehiculos\n");
    }
}
