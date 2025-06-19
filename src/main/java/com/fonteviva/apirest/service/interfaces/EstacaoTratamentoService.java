package com.fonteviva.apirest.service.interfaces;
import com.fonteviva.apirest.dto.EstacaoTratamentoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EstacaoTratamentoService {
    EstacaoTratamentoDTO salvar(EstacaoTratamentoDTO dto);
    List<EstacaoTratamentoDTO> listarTodas();

    Page<EstacaoTratamentoDTO> listar(Pageable pageable);

    Optional<EstacaoTratamentoDTO> buscarPorId(Long id);
    void deletar(Long id);
    EstacaoTratamentoDTO atualizar(Long id, EstacaoTratamentoDTO dto);
}
