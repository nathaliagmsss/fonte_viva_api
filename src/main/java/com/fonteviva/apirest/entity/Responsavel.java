package com.fonteviva.apirest.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_FV_RESPONSAVEL")
public class Responsavel {
    @Id
    @Column(name = "DS_CPF", length = 11)
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Column(name = "NM_RESPONSAVEL", nullable = false, length = 100)
    @Size(max = 100)
    @NotBlank
    private String nome;

    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstacaoTratamento> estacoes = new ArrayList<>();

    public Responsavel(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    public Responsavel() {

    }

    // Getters e setters
    public List<EstacaoTratamento> getEstacoes() {
        return estacoes;
    }

    public void setEstacoes(List<EstacaoTratamento> estacoes) {
        this.estacoes = estacoes;
    }

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
}

