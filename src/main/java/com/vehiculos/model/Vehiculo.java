package com.vehiculos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Document(collection = "vehiculos")
public class Vehiculo {

    @Id
    private String id;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1900, message = "El año debe ser mayor a 1900")
    @Max(value = 2026, message = "El año no puede ser mayor a 2026")
    private Integer año;

    @NotBlank(message = "El color es obligatorio")
    private String color;

    @NotBlank(message = "La placa es obligatoria")
    @Indexed(unique = true)
    private String placa;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
    private Double precio;

    @Pattern(regexp = "Nuevo|Usado|Seminuevo", message = "El estado debe ser: Nuevo, Usado o Seminuevo")
    private String estado = "Usado";

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor vacío
    public Vehiculo() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor completo
    public Vehiculo(String marca, String modelo, Integer año, String color, String placa, Double precio, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.color = color;
        this.placa = placa != null ? placa.toUpperCase() : null;
        this.precio = precio;
        this.estado = estado != null ? estado : "Usado";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa != null ? placa.toUpperCase() : null;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", color='" + color + '\'' +
                ", placa='" + placa + '\'' +
                ", precio=" + precio +
                ", estado='" + estado + '\'' +
                '}';
    }
}
