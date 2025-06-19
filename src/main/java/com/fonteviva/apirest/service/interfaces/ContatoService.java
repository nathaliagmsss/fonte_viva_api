package com.fonteviva.apirest.service.interfaces;

import com.fonteviva.apirest.entity.Contato;
import java.util.List;

public interface ContatoService {
    Contato salvar(Contato contato);
    Contato buscarPorId(Long id);
    List<Contato> listarTodos();
    Contato atualizar(Contato contato);
    void deletarPorId(Long id);
}

