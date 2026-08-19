package com.odonto.consultorio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "tratamientos")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del tratamiento es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @NotNull(message = "El costo base es obligatorio")
    @Positive(message = "El costo base debe ser mayor a 0")
    @Column(name = "costo_base", nullable = false)
    private BigDecimal costoBase;

    @Column(name = "duracion_estimada_min")
    private Integer duracionEstimadaMin = 30;

    public Tratamiento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getCostoBase() { return costoBase; }
    public void setCostoBase(BigDecimal costoBase) { this.costoBase = costoBase; }

    public Integer getDuracionEstimadaMin() { return duracionEstimadaMin; }
    public void setDuracionEstimadaMin(Integer duracionEstimadaMin) { this.duracionEstimadaMin = duracionEstimadaMin; }
}