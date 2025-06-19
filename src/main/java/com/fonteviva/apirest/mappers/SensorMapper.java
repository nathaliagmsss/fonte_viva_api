package com.fonteviva.apirest.mappers;
import com.fonteviva.apirest.dto.SensorDTO;
import com.fonteviva.apirest.entity.Sensor;
import com.fonteviva.apirest.entity.EstacaoTratamento;

public class SensorMapper {
    public static Sensor toEntity(SensorDTO dto, EstacaoTratamento estacao) {
        return new Sensor(dto.getId(), dto.getTipo(), dto.getTipoMedida(), estacao);
    }

    public static SensorDTO toDTO(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setId(sensor.getId());
        dto.setTipo(sensor.getTipo());
        dto.setTipoMedida(sensor.getTipoMedida());
        dto.setIdEstacaoTratamento(sensor.getEstacaoTratamento().getId());
        return dto;
    }
}

