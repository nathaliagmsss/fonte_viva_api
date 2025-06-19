package com.fonteviva.apirest.repository;
import com.fonteviva.apirest.entity.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponsavelRepository extends JpaRepository<Responsavel, String> {
    List<Responsavel> findByNomeContainingIgnoreCase(String nome);

}
