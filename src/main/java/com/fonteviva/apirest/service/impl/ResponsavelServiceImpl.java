package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.dto.ResponsavelDTO;
import com.fonteviva.apirest.entity.Responsavel;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.mappers.ResponsavelMapper;
import com.fonteviva.apirest.repository.ResponsavelRepository;
import com.fonteviva.apirest.service.interfaces.ResponsavelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResponsavelServiceImpl implements ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public ResponsavelServiceImpl(ResponsavelRepository responsavelRepository) {
        this.responsavelRepository = responsavelRepository;
    }

    @Override
    public ResponsavelDTO salvar(ResponsavelDTO dto) {
        Responsavel responsavel = ResponsavelMapper.toEntity(dto);
        return ResponsavelMapper.toDTO(responsavelRepository.save(responsavel));
    }

    @Override
    public List<ResponsavelDTO> listarTodos() {
        return responsavelRepository.findAll()
                .stream()
                .map(ResponsavelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResponsavelDTO> buscarPorCpf(String cpf) {
        return responsavelRepository.findById(cpf)
                .map(ResponsavelMapper::toDTO);
    }

    @Override
    public void deletar(String cpf) {
        responsavelRepository.deleteById(cpf);
    }

    @Override
    public ResponsavelDTO atualizar(String cpf, ResponsavelDTO dto) {
        Responsavel responsavel = responsavelRepository.findById(cpf)
                .orElseThrow(() -> new ResourceNotFoundException("Responsável não encontrado"));

        responsavel.setNome(dto.getNome());

        return ResponsavelMapper.toDTO(responsavelRepository.save(responsavel));
    }
}
