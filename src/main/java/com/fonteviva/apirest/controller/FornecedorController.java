package com.fonteviva.apirest.controller;

import com.fonteviva.apirest.dto.FornecedorDTO;
import com.fonteviva.apirest.entity.Endereco;
import com.fonteviva.apirest.entity.Fornecedor;
import com.fonteviva.apirest.mappers.FornecedorMapper;
import com.fonteviva.apirest.service.interfaces.EnderecoService;
import com.fonteviva.apirest.service.interfaces.FornecedorService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/fornecedores")
@SecurityRequirement(name = "bearerAuth")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<FornecedorDTO> criarFornecedor(@RequestBody @Valid FornecedorDTO fornecedorDTO) {
        Endereco endereco = enderecoService.buscarPorId(fornecedorDTO.getIdEndereco());
        Fornecedor fornecedor = FornecedorMapper.toEntity(fornecedorDTO, endereco);
        Fornecedor fornecedorSalvo = fornecedorService.salvar(fornecedor);
        return ResponseEntity.ok(FornecedorMapper.toDTO(fornecedorSalvo));
    }


    @GetMapping("/{cnpj}")
    public ResponseEntity<FornecedorDTO> buscarPorCnpj(@PathVariable String cnpj) {
        Fornecedor fornecedor = fornecedorService.buscarPorCnpj(cnpj);
        FornecedorDTO dto = FornecedorMapper.toDTO(fornecedor);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> listarTodos() {
        List<Fornecedor> fornecedores = fornecedorService.listarTodos();
        List<FornecedorDTO> fornecedorDTO = fornecedores.stream().map(FornecedorMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(fornecedorDTO);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<FornecedorDTO> atualizarFornecedor(@PathVariable String cnpj, @RequestBody @Valid FornecedorDTO fornecedorDTO) {
        // Garantir que o CNPJ do path seja o mesmo do corpo
        if (!cnpj.equals(fornecedorDTO.getCnpj())) {
            return ResponseEntity.badRequest().build();
        }

        Endereco endereco = enderecoService.buscarPorId(fornecedorDTO.getIdEndereco());
        Fornecedor fornecedor = FornecedorMapper.toEntity(fornecedorDTO, endereco);
        Fornecedor atualizado = fornecedorService.atualizar(fornecedor);
        return ResponseEntity.ok(FornecedorMapper.toDTO(atualizado));
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable String cnpj) {
        fornecedorService.deletarPorCnpj(cnpj);
        return ResponseEntity.noContent().build();
    }
}
