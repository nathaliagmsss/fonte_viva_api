package com.fonteviva.apirest.dto;

import com.fonteviva.apirest.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CNPJ;

public class FornecedorDTO {

    //    @Pattern(regexp = "\\d{14}", message = "CNPJ deve conter 14 dígitos numéricos")
    //    private String cnpj;

    @CNPJ(message = "CNPJ inválido") // Usando a anotação do Hibernate Validator
    private String cnpj;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100)
    private String nome;

    private Long idEndereco;

    public FornecedorDTO(String cnpj, String nome, Long idEndereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.idEndereco = idEndereco;
    }

    public FornecedorDTO() {
    }

    // Getters e Setters
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

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }
}
