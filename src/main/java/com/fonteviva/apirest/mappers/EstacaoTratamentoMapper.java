package com.fonteviva.apirest.mappers;
import com.fonteviva.apirest.dto.EstacaoTratamentoDTO;
import com.fonteviva.apirest.dto.SensorDTO;
import com.fonteviva.apirest.entity.EstacaoTratamento;
import com.fonteviva.apirest.entity.Responsavel;
import com.fonteviva.apirest.entity.Sensor;

import java.util.List;
import java.util.stream.Collectors;

public class EstacaoTratamentoMapper {

    public static EstacaoTratamento toEntity(EstacaoTratamentoDTO dto, Responsavel responsavel, List<Sensor> sensores) {
        EstacaoTratamento estacao = new EstacaoTratamento();
        estacao.setId(dto.getId());
        estacao.setDataInstalacao(dto.getDataInstalacao());
        estacao.setStatus(dto.getStatus());
        estacao.setResponsavel(responsavel);
        estacao.setSensores(sensores);
        return estacao;
    }

    public static EstacaoTratamentoDTO toDTO(EstacaoTratamento estacao) {
        EstacaoTratamentoDTO dto = new EstacaoTratamentoDTO();
        dto.setId(estacao.getId());
        dto.setDataInstalacao(estacao.getDataInstalacao());
        dto.setStatus(estacao.getStatus());
        dto.setCpfResponsavel(estacao.getResponsavel() != null ? estacao.getResponsavel().getCpf() : null);

        dto.setSensores(
                estacao.getSensores() != null
                        ? estacao.getSensores()
                        .stream()
                        .map(SensorMapper::toDTO)
                        .collect(Collectors.toList())
                        : null
        );

        return dto;
    }
}
