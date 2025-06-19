package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.entity.Contato;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.repository.ContatoRepository;
import com.fonteviva.apirest.service.interfaces.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato salvar(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public Contato buscarPorId(Long id) {
        Optional<Contato> contatoOpt = contatoRepository.findById(id);
        return contatoOpt.orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado: " + id));
    }

    @Override
    public List<Contato> listarTodos() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato atualizar(Contato contato) {
        if (!contatoRepository.existsById(contato.getId())) {
            throw new ResourceNotFoundException("Contato não encontrado para atualizar: " + contato.getId());
        }
        return contatoRepository.save(contato);
    }

    @Override
    public void deletarPorId(Long id) {
        if (!contatoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Contato não encontrado para deletar: " + id);
        }
        contatoRepository.deleteById(id);
    }
}
