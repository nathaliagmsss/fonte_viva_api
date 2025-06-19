package com.fonteviva.apirest.mappers;

import com.fonteviva.apirest.dto.FornecedorDTO;
import com.fonteviva.apirest.entity.Endereco;
import com.fonteviva.apirest.entity.Fornecedor;

public class FornecedorMapper {

    public static Fornecedor toEntity(FornecedorDTO dto, Endereco endereco) {
        return new Fornecedor(dto.getCnpj(), dto.getNome(), endereco);
    }

    public static FornecedorDTO toDTO(Fornecedor fornecedor) {
        FornecedorDTO dto = new FornecedorDTO();
        dto.setCnpj(fornecedor.getCnpj());
        dto.setNome(fornecedor.getNome());
        dto.setIdEndereco(fornecedor.getEndereco().getId());
        return dto;
    }
}
