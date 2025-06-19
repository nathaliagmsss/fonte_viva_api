package com.fonteviva.apirest.controller;

import com.fonteviva.apirest.entity.Endereco;
import com.fonteviva.apirest.service.interfaces.EnderecoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@SecurityRequirement(name = "bearerAuth")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody @Valid Endereco endereco) {
        Endereco novoEndereco = enderecoService.salvar(endereco);
        return ResponseEntity.ok(novoEndereco);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscarPorId(@PathVariable Long id) {
        Endereco endereco = enderecoService.buscarPorId(id);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodos() {
        List<Endereco> enderecos = enderecoService.listarTodos();
        return ResponseEntity.ok(enderecos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Long id, @RequestBody @Valid Endereco endereco) {
        if (!id.equals(endereco.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Endereco atualizado = enderecoService.atualizar(endereco);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

