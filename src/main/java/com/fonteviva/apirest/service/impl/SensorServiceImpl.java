package com.fonteviva.apirest.service.impl;

import com.fonteviva.apirest.dto.SensorDTO;
import com.fonteviva.apirest.entity.EstacaoTratamento;
import com.fonteviva.apirest.entity.Sensor;
import com.fonteviva.apirest.exception.ResourceNotFoundException;
import com.fonteviva.apirest.mappers.SensorMapper;
import com.fonteviva.apirest.repository.EstacaoTratamentoRepository;
import com.fonteviva.apirest.repository.SensorRepository;
import com.fonteviva.apirest.service.interfaces.SensorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;
    private final EstacaoTratamentoRepository estacaoRepository;

    public SensorServiceImpl(SensorRepository sensorRepository, EstacaoTratamentoRepository estacaoRepository) {
        this.sensorRepository = sensorRepository;
        this.estacaoRepository = estacaoRepository;
    }

    @Override
    public SensorDTO salvar(SensorDTO dto) {
        EstacaoTratamento estacao = estacaoRepository.findById(dto.getIdEstacaoTratamento())
                .orElseThrow(() -> new ResourceNotFoundException("Estação de tratamento não encontrada"));

        Sensor sensor = SensorMapper.toEntity(dto, estacao);
        return SensorMapper.toDTO(sensorRepository.save(sensor));
    }

    @Override
    public List<SensorDTO> listarTodos() {
        return sensorRepository.findAll()
                .stream()
                .map(SensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SensorDTO> buscarPorId(Long id) {
        return sensorRepository.findById(id)
                .map(SensorMapper::toDTO);
    }

    @Override
    public List<SensorDTO> listarPorEstacao(Long idEstacao) {
        return sensorRepository.findByEstacaoTratamentoId(idEstacao)
                .stream()
                .map(SensorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletar(Long id) {
        if (!sensorRepository.existsById(id)) { // Verifique se o sensor existe
            throw new ResourceNotFoundException("Sensor com ID " + id + " não encontrado.");
        }
        sensorRepository.deleteById(id);
    }

    @Override
    public SensorDTO atualizar(Long id, SensorDTO dto) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sensor não encontrado"));

        sensor.setTipo(dto.getTipo());
        sensor.setTipoMedida(dto.getTipoMedida());

        // Atualiza a estação, se o ID mudar
        if (!sensor.getEstacaoTratamento().getId().equals(dto.getIdEstacaoTratamento())) {
            EstacaoTratamento estacao = estacaoRepository.findById(dto.getIdEstacaoTratamento())
                    .orElseThrow(() -> new ResourceNotFoundException("Estação de Tratamento não encontrada"));
            sensor.setEstacaoTratamento(estacao);
        }

        Sensor atualizado = sensorRepository.save(sensor);
        return SensorMapper.toDTO(atualizado);
    }

}
