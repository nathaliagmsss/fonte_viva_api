package com.fonteviva.apirest.repository;

import com.fonteviva.apirest.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {

    // DS_CNPJ é PK e é String

    // Buscar fornecedor pelo ID do endereço
    List<Fornecedor> findByEnderecoId(Long idEndereco);

    // Consulta customizada para trazer fornecedores com endereço em um estado específico
    @Query("SELECT f FROM Fornecedor f WHERE f.endereco.estado = :estado")
    List<Fornecedor> findByEstado(String estado);
}
