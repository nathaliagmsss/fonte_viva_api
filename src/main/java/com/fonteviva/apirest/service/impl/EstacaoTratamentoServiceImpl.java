package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.dto.EstacaoTratamentoDTO;
import com.fonteviva.apirest.entity.EstacaoTratamento;
import com.fonteviva.apirest.entity.Responsavel;
import com.fonteviva.apirest.entity.Sensor;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.mappers.EstacaoTratamentoMapper;
import com.fonteviva.apirest.mappers.SensorMapper;
import com.fonteviva.apirest.repository.EstacaoTratamentoRepository;
import com.fonteviva.apirest.repository.ResponsavelRepository;
import com.fonteviva.apirest.service.interfaces.EstacaoTratamentoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstacaoTratamentoServiceImpl implements EstacaoTratamentoService {
    private final EstacaoTratamentoRepository estacaoRepository;
    private final ResponsavelRepository responsavelRepository;

    public EstacaoTratamentoServiceImpl(EstacaoTratamentoRepository estacaoRepository, ResponsavelRepository responsavelRepository) {
        this.estacaoRepository = estacaoRepository;
        this.responsavelRepository = responsavelRepository;
    }

    @Override
    public EstacaoTratamentoDTO salvar(EstacaoTratamentoDTO dto) {
        Responsavel responsavel = responsavelRepository.findById(dto.getCpfResponsavel())
                .orElseThrow(() -> new ResourceNotFoundException("Responsável não encontrado"));

        // Criar a instância da EstacaoTratamento SEM sensores ainda
        EstacaoTratamento estacao = EstacaoTratamentoMapper.toEntity(dto, responsavel, new ArrayList<>());

        // Agora podemos mapear os sensores, usando a instância de estacao já criada
        List<Sensor> sensores = dto.getSensores().stream()
                .map(sensorDTO -> SensorMapper.toEntity(sensorDTO, estacao))
                .collect(Collectors.toList());

        // Associar os sensores à estacao
        estacao.setSensores(sensores);

        return EstacaoTratamentoMapper.toDTO(estacaoRepository.save(estacao));
    }



    @Override
    public List<EstacaoTratamentoDTO> listarTodas() {
        return estacaoRepository.findAll()
                .stream()
                .map(EstacaoTratamentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<EstacaoTratamentoDTO> listar(Pageable pageable) {
        return estacaoRepository.findAll(pageable)
                .map(EstacaoTratamentoMapper::toDTO);
    }


    @Override
    public Optional<EstacaoTratamentoDTO> buscarPorId(Long id) {
        return estacaoRepository.findById(id)
                .map(EstacaoTratamentoMapper::toDTO);
    }

    @Override
    public void deletar(Long id) {
        EstacaoTratamento estacao = estacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estação não encontrada"));
        estacaoRepository.delete(estacao);
    }

    @Override
    public EstacaoTratamentoDTO atualizar(Long id, EstacaoTratamentoDTO dto) {
        EstacaoTratamento estacao = estacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estação não encontrada"));

        Responsavel responsavel = responsavelRepository.findById(dto.getCpfResponsavel())
                .orElseThrow(() -> new ResourceNotFoundException("Responsável não encontrado"));

        estacao.setDataInstalacao(dto.getDataInstalacao());
        estacao.setStatus(dto.getStatus());
        estacao.setResponsavel(responsavel);

        List<Sensor> sensores = dto.getSensores().stream()
                .map(sensorDTO -> SensorMapper.toEntity(sensorDTO, estacao))
                .collect(Collectors.toList());
        estacao.setSensores(sensores);

        return EstacaoTratamentoMapper.toDTO(estacaoRepository.save(estacao));
    }
}
