package com.fonteviva.apirest.service.interfaces;

import com.fonteviva.apirest.entity.Endereco;
import java.util.List;

public interface EnderecoService {
    Endereco salvar(Endereco endereco);
    Endereco buscarPorId(Long id);
    List<Endereco> listarTodos();
    Endereco atualizar(Endereco endereco);
    void deletarPorId(Long id);
}

