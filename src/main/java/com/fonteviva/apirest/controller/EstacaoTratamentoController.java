package com.fonteviva.apirest.controller;
import com.fonteviva.apirest.dto.EstacaoTratamentoDTO;
import com.fonteviva.apirest.service.interfaces.EstacaoTratamentoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/estacoes")
@SecurityRequirement(name = "bearerAuth")
public class EstacaoTratamentoController {

    @Autowired
    private EstacaoTratamentoService estacaoService;

    @PostMapping
    public ResponseEntity<EstacaoTratamentoDTO> criarEstacao(@RequestBody @Valid EstacaoTratamentoDTO dto) {
        EstacaoTratamentoDTO salvo = estacaoService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<EstacaoTratamentoDTO>> listarTodas() {
        List<EstacaoTratamentoDTO> estacoes = estacaoService.listarTodas();
        return ResponseEntity.ok(estacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacaoTratamentoDTO> buscarPorId(@PathVariable Long id) {
        return estacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/paginado")
    public ResponseEntity<Page<EstacaoTratamentoDTO>> listarComPaginacao(
            @PageableDefault(size = 10, sort = "dataInstalacao", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(estacaoService.listar(pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacaoTratamentoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid EstacaoTratamentoDTO dto) {
        EstacaoTratamentoDTO atualizado = estacaoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}