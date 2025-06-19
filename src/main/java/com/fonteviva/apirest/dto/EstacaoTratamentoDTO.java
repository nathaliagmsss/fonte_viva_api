package com.fonteviva.apirest.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

public class EstacaoTratamentoDTO {
    private Long id;
    @NotNull(message = "Data é obrigatória")
    private Date dataInstalacao;
    @NotBlank(message = "Status é obrigatório")
    private String status;
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    @NotNull(message = "CPF do responsável é obrigatório")
    private String cpfResponsavel;
    @Valid
    private List<SensorDTO> sensores;

    public EstacaoTratamentoDTO() {}

    public EstacaoTratamentoDTO(Long id, Date dataInstalacao, String status, String cpfResponsavel, List<SensorDTO> sensores) {
        this.id = id;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
        this.cpfResponsavel = cpfResponsavel;
        this.sensores = sensores;
    }

    // Getters e Setters
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

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public List<SensorDTO> getSensores() {
        return sensores;
    }

    public void setSensores(List<SensorDTO> sensores) {
        this.sensores = sensores;
    }
}
