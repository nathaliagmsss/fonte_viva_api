package com.fonteviva.apirest.controller;

//import com.fonteviva.apirest.dto.UsuarioRegistroDTO; // Importe seu DTO de registro
//import com.fonteviva.apirest.entity.Usuario;
//import com.fonteviva.apirest.repository.UsuarioRepository;
//import io.swagger.v3.oas.annotations.Operation; // Importe Operation
//import io.swagger.v3.oas.annotations.media.Content; // Importe Content
//import io.swagger.v3.oas.annotations.media.Schema; // Importe Schema
//import io.swagger.v3.oas.annotations.responses.ApiResponse; // Importe ApiResponse
//import io.swagger.v3.oas.annotations.responses.ApiResponses; // Importe ApiResponses
//import io.swagger.v3.oas.annotations.security.SecurityRequirement; // Se for usar para outros endpoints
//import jakarta.validation.Valid; // Importe @Valid para validação automática
//import org.springframework.http.HttpStatus; // Importe HttpStatus
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/usuarios")
//public class UsuarioController {
//
//    private final UsuarioRepository usuarioRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
//        this.usuarioRepository = usuarioRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping("/register")
//    @Operation(summary = "Registra um novo usuário no sistema") // Descrição para o Swagger
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso"), // Sucesso
//            @ApiResponse(responseCode = "400", description = "Requisição inválida (ex: validação de campos)",
//                    content = @Content(schema = @Schema(implementation = String.class))), // Mensagem de erro
//            @ApiResponse(responseCode = "409", description = "E-mail já cadastrado",
//                    content = @Content(schema = @Schema(implementation = String.class))) // Conflito de e-mail
//    })
//    public ResponseEntity<String> register(@Valid @RequestBody UsuarioRegistroDTO registroDTO) {
//        // 1. Verificar se o e-mail já existe
//        if (usuarioRepository.findByEmail(registroDTO.getEmail()).isPresent()) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado"); // Use 409 Conflict
//        }
//
//        // 2. Criar a entidade Usuario a partir do DTO
//        Usuario novoUsuario = new Usuario();
//        novoUsuario.setNome(registroDTO.getNome());
//        novoUsuario.setEmail(registroDTO.getEmail());
//        novoUsuario.setSenha(passwordEncoder.encode(registroDTO.getSenha()));
//
//
//        // 3. Salvar o novo usuário
//        usuarioRepository.save(novoUsuario);
//
//        // 4. Retornar resposta de sucesso
//        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso"); // Use 201 Created
//    }
//}

import com.fonteviva.apirest.dto.UsuarioRegistroDTO;
import com.fonteviva.apirest.entity.Usuario;
import com.fonteviva.apirest.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioRegistroDTO request) {
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("E-mail já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));

        usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuário registrado com sucesso");
    }


//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
//        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
//            return ResponseEntity.badRequest().body("E-mail já cadastrado");
//        }
//
//        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
//        usuarioRepository.save(usuario);
//
//        return ResponseEntity.ok("Usuário registrado com sucesso");
//    }
}

