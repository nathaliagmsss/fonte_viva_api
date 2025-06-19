package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.entity.Material;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.repository.MaterialRepository;
import com.fonteviva.apirest.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public Material salvar(Material material) {
        return materialRepository.save(material);
    }

    @Override
    public Material buscarPorId(Long id) {
        Optional<Material> materialOpt = materialRepository.findById(id);
        return materialOpt.orElseThrow(() -> new ResourceNotFoundException("Material não encontrado: " + id));
    }

    @Override
    public List<Material> listarTodos() {
        return materialRepository.findAll();
    }

    @Override
    public Material atualizar(Material material) {
        if (!materialRepository.existsById(material.getId())) {
            throw new ResourceNotFoundException("Material não encontrado para atualizar: " + material.getId());
        }
        return materialRepository.save(material);
    }

    @Override
    public void deletarPorId(Long id) {
        if (!materialRepository.existsById(id)) {
            throw new ResourceNotFoundException("Material não encontrado para deletar: " + id);
        }
        materialRepository.deleteById(id);
    }
}
