package com.fonteviva.apirest.repository;
import com.fonteviva.apirest.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    // Buscar contatos por telefone (exato)
    List<Contato> findByTelefone(String telefone);

    // Buscar contatos por e-mail (exato)
    List<Contato> findByEmail(String email);

    // Buscar contatos por CNPJ do fornecedor associado
    List<Contato> findByCnpj(String cnpj);
}

