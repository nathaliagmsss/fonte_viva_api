package com.fonteviva.apirest.service.interfaces;

import com.fonteviva.apirest.entity.Material;

import java.util.List;

public interface MaterialService {
    Material salvar(Material material);
    Material buscarPorId(Long id);
    List<Material> listarTodos();
    Material atualizar(Material material);
    void deletarPorId(Long id);
}
