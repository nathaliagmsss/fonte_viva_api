package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.entity.Fornecedor;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.repository.FornecedorRepository;
import com.fonteviva.apirest.service.interfaces.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public Fornecedor salvar(Fornecedor fornecedor) {
        // Aqui poderia ter validação (ex: CNPJ válido, etc)
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public Fornecedor buscarPorCnpj(String cnpj) {
        Optional<Fornecedor> fornecedorOpt = fornecedorRepository.findById(cnpj);
        return fornecedorOpt.orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado: " + cnpj));
    }

    @Override
    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    @Override
    public Fornecedor atualizar(Fornecedor fornecedor) {
        if (!fornecedorRepository.existsById(fornecedor.getCnpj())) {
            throw new ResourceNotFoundException("Fornecedor não encontrado para atualizar: " + fornecedor.getCnpj());
        }
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void deletarPorCnpj(String cnpj) {
        if (!fornecedorRepository.existsById(cnpj)) {
            throw new ResourceNotFoundException("Fornecedor não encontrado para deletar: " + cnpj);
        }
        fornecedorRepository.deleteById(cnpj);
    }
}
