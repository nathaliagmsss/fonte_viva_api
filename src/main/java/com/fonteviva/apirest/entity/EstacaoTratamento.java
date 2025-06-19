package com.fonteviva.apirest.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_FV_ESTACAO_TRATAMENTO")
public class EstacaoTratamento {
    @Id
    @Column(name = "ID_ESTACAO_TRATAMENTO")
    @SequenceGenerator(name="SEQ_ID_ESTACAO", sequenceName = "SEQ_ID_ESTACAO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DT_INSTALACAO", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date dataInstalacao;

    @Column(name = "ST_ESTACAO", nullable = false, length = 1)
    @NotBlank
    private String status;

    @ManyToOne
    @JoinColumn(name = "DS_CPF")
    private Responsavel responsavel;

    @OneToMany(mappedBy = "estacaoTratamento", cascade = CascadeType.ALL)
    private List<Sensor> sensores = new ArrayList<>();

    public EstacaoTratamento(Long id, Date dataInstalacao, String status, Responsavel responsavel) {
        this.id = id;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
        this.responsavel = responsavel;
    }

    public EstacaoTratamento() {
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}