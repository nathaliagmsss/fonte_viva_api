package com.fonteviva.apirest.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "T_FV_MATERIAL")
public class Material {
    @Id
    @Column(name = "ID_MATERIAL")
    private Long id;

    @Lob
    @Column(name = "NM_MATERIAL", nullable = false)
    private String nome;

    @Column(name = "TP_MATERIAL", nullable = false, length = 32)
    private String tipo;

    @Column(name = "NR_QUANT_ESTOQUE", nullable = false)
    private Integer quantidadeEstoque;

    @Column(name = "NR_PRECO_UNIDADE", nullable = false)
    private Double precoUnidade;

    @ManyToOne
    @JoinColumn(name = "DS_CNPJ", nullable = false)
    private Fornecedor fornecedor;

    public Material(Long id, String nome, String tipo, Integer quantidadeEstoque, Double precoUnidade, Fornecedor fornecedor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.precoUnidade = precoUnidade;
        this.fornecedor = fornecedor;
    }

    public Material() {
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getPrecoUnidade() {
        return precoUnidade;
    }

    public void setPrecoUnidade(Double precoUnidade) {
        this.precoUnidade = precoUnidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
