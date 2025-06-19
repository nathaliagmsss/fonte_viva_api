package com.fonteviva.apirest.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class ResponsavelDTO {
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    private List<Long> idsEstacoes;

    public ResponsavelDTO() {}

    public ResponsavelDTO(String cpf, String nome, List<Long> idsEstacoes) {
        this.cpf = cpf;
        this.nome = nome;
        this.idsEstacoes = idsEstacoes;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getIdsEstacoes() {
        return idsEstacoes;
    }

    public void setIdsEstacoes(List<Long> idsEstacoes) {
        this.idsEstacoes = idsEstacoes;
    }
}

