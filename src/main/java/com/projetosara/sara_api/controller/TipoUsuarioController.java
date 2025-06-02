package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.dto.TipoUsuarioDTO;
import com.projetosara.sara_api.service.TipoUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/tipos-usuario")
@RequiredArgsConstructor
public class TipoUsuarioController {
    private final TipoUsuarioService service;

    @GetMapping
    public Page<TipoUsuarioDTO> listar(@RequestParam(required = false) String nome, Pageable pageable) {
        return service.listar(nome, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> buscarPorId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TipoUsuarioDTO> salvar(@RequestBody @Valid TipoUsuarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid TipoUsuarioDTO dto) {
        return service.update(id, dto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<TipoUsuarioDTO> buscarPorCodigo(@PathVariable String codigo) {
        return service.findByCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/count")
    public ResponseEntity<Long> contarTodos() {
        return ResponseEntity.ok(service.contarTodos());
    }
}