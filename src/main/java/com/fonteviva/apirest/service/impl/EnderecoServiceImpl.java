package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.entity.Endereco;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.repository.EnderecoRepository;
import com.fonteviva.apirest.service.interfaces.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco buscarPorId(Long id) {
        Optional<Endereco> enderecoOpt = enderecoRepository.findById(id);
        return enderecoOpt.orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado: " + id));
    }

    @Override
    public List<Endereco> listarTodos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        if (!enderecoRepository.existsById(endereco.getId())) {
            throw new ResourceNotFoundException("Endereço não encontrado para atualizar: " + endereco.getId());
        }
        return enderecoRepository.save(endereco);
    }

    @Override
    public void deletarPorId(Long id) {
        if (!enderecoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Endereço não encontrado para deletar: " + id);
        }
        enderecoRepository.deleteById(id);
    }
}

