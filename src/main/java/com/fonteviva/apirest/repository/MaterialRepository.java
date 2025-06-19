package com.fonteviva.apirest.repository;
import com.fonteviva.apirest.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByTipo(String tipoMaterial);

    List<Material> findByFornecedor_Cnpj(String cnpj);

    @Query("SELECT m FROM Material m WHERE m.quantidadeEstoque > :quantidade")
    List<Material> findByEstoqueMaiorQue(Integer quantidade);
}

