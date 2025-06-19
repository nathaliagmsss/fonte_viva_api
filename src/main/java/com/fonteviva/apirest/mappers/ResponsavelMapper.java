package com.fonteviva.apirest.mappers;
import com.fonteviva.apirest.dto.ResponsavelDTO;
import com.fonteviva.apirest.entity.EstacaoTratamento;
import com.fonteviva.apirest.entity.Responsavel;
import java.util.List;
import java.util.stream.Collectors;

public class ResponsavelMapper {

    public static Responsavel toEntity(ResponsavelDTO dto) {
        return new Responsavel(dto.getCpf(), dto.getNome());
    }

    public static ResponsavelDTO toDTO(Responsavel responsavel) {
        ResponsavelDTO dto = new ResponsavelDTO();
        dto.setCpf(responsavel.getCpf());
        dto.setNome(responsavel.getNome());
        dto.setIdsEstacoes(
                responsavel.getEstacoes() != null
                        ? responsavel.getEstacoes()
                        .stream()
                        .map(EstacaoTratamento::getId)
                        .collect(Collectors.toList())
                        : null
        );
        return dto;
    }
}
