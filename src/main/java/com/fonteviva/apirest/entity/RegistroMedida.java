package com.fonteviva.apirest.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "T_FV_REGISTRO_MEDIDA")
public class RegistroMedida {
    @Id
    @Column(name = "ID_REGISTRO", length = 64)
    private String id;

    @Column(name = "DT_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataRegistro;

    @Column(name = "NR_RESULTADO", nullable = false)
    private Double resultado;

    @ManyToOne
    @JoinColumn(name = "ID_SENSOR", nullable = false)
    private Sensor sensor;

    public RegistroMedida(String id, Date dataRegistro, Double resultado, Sensor sensor) {
        this.id = id;
        this.dataRegistro = dataRegistro;
        this.resultado = resultado;
        this.sensor = sensor;
    }

    public RegistroMedida() {
    }

    // Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
