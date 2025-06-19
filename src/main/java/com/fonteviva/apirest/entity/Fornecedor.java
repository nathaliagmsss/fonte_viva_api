package com.fonteviva.apirest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_FV_FORNECEDOR")
public class Fornecedor {
    @Id
    @Column(name = "DS_CNPJ", length = 14)
    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
    private String cnpj;

    @Column(name = "NM_FORNECEDOR", nullable = false, length = 100)
    @Size(max = 100)
    @NotBlank
    private String nome;

    @ManyToOne
    @JoinColumn(name = "ID_ENDERECO", nullable = false)
    private Endereco endereco;

    public Fornecedor(String cnpj, String nome, Endereco endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Fornecedor() {
    }

    // Getters e setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "cnpj='" + cnpj + '\'' +
                ", nome='" + nome + '\'' +
                ", idEndereco=" + endereco +
                '}';
    }
}

