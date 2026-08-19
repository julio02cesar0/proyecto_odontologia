package com.odonto.consultorio.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "atenciones")
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "cita_id", nullable = false, unique = true)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;

    private LocalDateTime fecha = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "costo_final", nullable = false)
    private BigDecimal costoFinal;

    public Atencion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cita getCita() { return cita; }
    public void setCita(Cita cita) { this.cita = cita; }

    public Tratamiento getTratamiento() { return tratamiento; }
    public void setTratamiento(Tratamiento tratamiento) { this.tratamiento = tratamiento; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public BigDecimal getCostoFinal() { return costoFinal; }
    public void setCostoFinal(BigDecimal costoFinal) { this.costoFinal = costoFinal; }
}
