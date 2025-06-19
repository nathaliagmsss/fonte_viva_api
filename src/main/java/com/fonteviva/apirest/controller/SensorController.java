package com.fonteviva.apirest.controller;
import com.fonteviva.apirest.dto.SensorDTO;
import com.fonteviva.apirest.service.interfaces.SensorService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sensores")
@SecurityRequirement(name = "bearerAuth")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<SensorDTO> criarSensor(@RequestBody @Valid SensorDTO dto) {
        SensorDTO salvo = sensorService.salvar(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<SensorDTO>> listarTodos() {
        List<SensorDTO> sensores = sensorService.listarTodos();
        return ResponseEntity.ok(sensores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> buscarPorId(@PathVariable Long id) {
        return sensorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid SensorDTO dto) {
        SensorDTO atualizado = sensorService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sensor deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Sensor não encontrado")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        sensorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}