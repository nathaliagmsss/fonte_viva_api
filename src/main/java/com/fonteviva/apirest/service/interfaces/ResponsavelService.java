package com.fonteviva.apirest.service.interfaces;
import com.fonteviva.apirest.dto.ResponsavelDTO;
import java.util.List;
import java.util.Optional;

public interface ResponsavelService {
    ResponsavelDTO salvar(ResponsavelDTO dto);
    List<ResponsavelDTO> listarTodos();
    Optional<ResponsavelDTO> buscarPorCpf(String cpf);
    void deletar(String cpf);
    ResponsavelDTO atualizar(String cpf, ResponsavelDTO dto);
}
