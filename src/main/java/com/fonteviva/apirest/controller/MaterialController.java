package com.fonteviva.apirest.controller;

import com.fonteviva.apirest.entity.Material;
import com.fonteviva.apirest.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> criarMaterial(@RequestBody Material material) {
        Material novoMaterial = materialService.salvar(material);
        return ResponseEntity.ok(novoMaterial);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> buscarPorId(@PathVariable Long id) {
        Material material = materialService.buscarPorId(id);
        return ResponseEntity.ok(material);
    }

    @GetMapping
    public ResponseEntity<List<Material>> listarTodos() {
        List<Material> materials = materialService.listarTodos();
        return ResponseEntity.ok(materials);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> atualizarMaterial(@PathVariable Long id, @RequestBody Material material) {
        if (!id.equals(material.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Material atualizado = materialService.atualizar(material);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMaterial(@PathVariable Long id) {
        materialService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}

