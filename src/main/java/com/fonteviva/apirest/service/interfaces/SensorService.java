package com.fonteviva.apirest.service.interfaces;
import com.fonteviva.apirest.dto.ResponsavelDTO;
import com.fonteviva.apirest.dto.SensorDTO;
import java.util.List;
import java.util.Optional;

public interface SensorService {
    SensorDTO salvar(SensorDTO dto);
    List<SensorDTO> listarTodos();
    Optional<SensorDTO> buscarPorId(Long id);
    List<SensorDTO> listarPorEstacao(Long idEstacao);
    void deletar(Long id);
    SensorDTO atualizar(Long id, SensorDTO dto);
}
