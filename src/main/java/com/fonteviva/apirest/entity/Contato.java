package com.fonteviva.apirest.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "T_FV_CONTATO")
public class Contato {
    @Id
    @Column(name = "ID_CONTATO")
    private Long id;

    @Column(name = "DS_TELEFONE", nullable = false, length = 14)
    private String telefone;

    @Column(name = "DS_EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "DS_CPF", length = 11)
    private String cpf;

    @Column(name = "DS_CNPJ", length = 14)
    private String cnpj;

    public Contato(Long id, String telefone, String email, String cpf, String cnpj) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public Contato() {
    }

    // Getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
