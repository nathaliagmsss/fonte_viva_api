package com.fonteviva.apirest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SensorDTO {
    private Long id;
    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;
    @NotBlank(message = "Tipo de medida é obrigatório")
    private String tipoMedida;
    @NotNull(message = "ID da Estação de Tratamento é obrigatório")
    private Long idEstacaoTratamento;

    public SensorDTO() {}

    public SensorDTO(Long id, String tipo, String tipoMedida, Long idEstacaoTratamento) {
        this.id = id;
        this.tipo = tipo;
        this.tipoMedida = tipoMedida;
        this.idEstacaoTratamento = idEstacaoTratamento;
    }

    // Getters e Setters

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

    public Long getIdEstacaoTratamento() {
        return idEstacaoTratamento;
    }

    public void setIdEstacaoTratamento(Long idEstacaoTratamento) {
        this.idEstacaoTratamento = idEstacaoTratamento;
    }
}
