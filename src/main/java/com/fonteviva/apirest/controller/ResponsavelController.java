package com.fonteviva.apirest.controller;
import com.fonteviva.apirest.dto.ResponsavelDTO;
import com.fonteviva.apirest.service.interfaces.ResponsavelService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/responsaveis")
@SecurityRequirement(name = "bearerAuth")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<ResponsavelDTO> criarResponsavel(@RequestBody @Valid ResponsavelDTO dto) {
        ResponsavelDTO salvo = responsavelService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> listarTodos() {
        List<ResponsavelDTO> responsaveis = responsavelService.listarTodos();
        return ResponseEntity.ok(responsaveis);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ResponsavelDTO> buscarPorCpf(@PathVariable String cpf) {
        return responsavelService.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ResponsavelDTO> atualizar(@PathVariable String cpf, @RequestBody @Valid ResponsavelDTO dto) {
        if (!cpf.equals(dto.getCpf())) {
            return ResponseEntity.badRequest().build();
        }

        ResponsavelDTO atualizado = responsavelService.atualizar(cpf, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deletar(@PathVariable String cpf) {
        responsavelService.deletar(cpf);
        return ResponseEntity.noContent().build();
    }
}
