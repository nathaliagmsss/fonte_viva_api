package com.fonteviva.apirest.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "T_FV_SENSOR")
public class Sensor {
    @Id
    @Column(name = "ID_SENSOR")
    @SequenceGenerator(name = "SEQ_ID_SENSOR", sequenceName = "SEQ_ID_SENSOR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ID_SENSOR")
    private Long id;

    @Column(name = "TP_SENSOR", nullable = false, length = 32)
    @NotBlank
    private String tipo;

    @Column(name = "TP_MEDIDA", length = 10)
    private String tipoMedida;

    @ManyToOne
    @JoinColumn(name = "ID_ESTACAO_TRATAMENTO", nullable = false)
    @NotNull
    private EstacaoTratamento estacaoTratamento;

    public Sensor(Long id, String tipo, String tipoMedida, EstacaoTratamento estacaoTratamento) {
        this.id = id;
        this.tipo = tipo;
        this.tipoMedida = tipoMedida;
        this.estacaoTratamento = estacaoTratamento;
    }

    public Sensor() {
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public EstacaoTratamento getEstacaoTratamento() {
        return estacaoTratamento;
    }

    public void setEstacaoTratamento(EstacaoTratamento estacaoTratamento) {
        this.estacaoTratamento = estacaoTratamento;
    }
}
