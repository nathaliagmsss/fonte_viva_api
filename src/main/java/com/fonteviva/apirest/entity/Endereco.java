package com.fonteviva.apirest.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "T_FV_ENDERECO")
public class Endereco {
    @Id
    @Column(name = "ID_ENDERECO")
    @SequenceGenerator(name = "SEQ_ID_ENDERECO", sequenceName = "SEQ_ID_ENDERECO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DS_PAIS", nullable = false, length = 32)
    @Size(max = 32)
    @NotBlank
    private String pais;

    @Column(name = "DS_ESTADO", nullable = false, length = 20)
    @Size(max = 20)
    @NotBlank
    private String estado;

    @Column(name = "DS_CIDADE", nullable = false, length = 64)
    @Size(max = 20)
    @NotBlank
    private String cidade;

    @Column(name = "DS_RUA", nullable = false, length = 100)
    @Size(max = 100)
    @NotBlank
    private String rua;

    @Pattern(regexp = "\\d{8}", message = "CEP deve conter 8 dígitos numéricos")
    @Size(min = 8, max = 8)
    @NotBlank
    @Column(name = "DS_CEP", nullable = false, length = 100)
    private String cep;


    public Endereco(Long id, String pais, String estado, String cidade, String rua, String cep) {
        this.id = id;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
    }

    public Endereco() {
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", estado='" + estado + '\'' +
                ", cidade='" + cidade + '\'' +
                ", rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

}
