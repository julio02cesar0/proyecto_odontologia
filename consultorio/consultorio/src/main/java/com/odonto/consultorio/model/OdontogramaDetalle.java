package com.odonto.consultorio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "odontograma_detalle")
public class OdontogramaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odontograma_id", nullable = false)
    private Odontograma odontograma;

    @Column(name = "diente_numero", nullable = false)
    private Integer dienteNumero;

    @Column(nullable = false, length = 20)
    private String cara;

    @ManyToOne
    @JoinColumn(name = "tratamiento_id", nullable = false)
    private Tratamiento tratamiento;

    private String estado = "DIAGNOSTICADO";

    public OdontogramaDetalle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Odontograma getOdontograma() { return odontograma; }
    public void setOdontograma(Odontograma odontograma) { this.odontograma = odontograma; }

    public Integer getDienteNumero() { return dienteNumero; }
    public void setDienteNumero(Integer dienteNumero) { this.dienteNumero = dienteNumero; }

    public String getCara() { return cara; }
    public void setCara(String cara) { this.cara = cara; }

    public Tratamiento getTratamiento() { return tratamiento; }
    public void setTratamiento(Tratamiento tratamiento) { this.tratamiento = tratamiento; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}