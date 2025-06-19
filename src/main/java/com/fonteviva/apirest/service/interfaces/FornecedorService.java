package com.fonteviva.apirest.service.interfaces;

import com.fonteviva.apirest.entity.Fornecedor;
import java.util.List;

public interface FornecedorService {
    Fornecedor salvar(Fornecedor fornecedor);
    Fornecedor buscarPorCnpj(String cnpj);
    List<Fornecedor> listarTodos();
    Fornecedor atualizar(Fornecedor fornecedor);
    void deletarPorCnpj(String cnpj);
}
