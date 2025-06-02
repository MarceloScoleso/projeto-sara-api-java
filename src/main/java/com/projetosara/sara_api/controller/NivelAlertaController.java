package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.dto.NivelAlertaDTO;
import com.projetosara.sara_api.service.NivelAlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/niveis-alerta")
@RequiredArgsConstructor
public class NivelAlertaController {
    private final NivelAlertaService service;

    @GetMapping
    public Page<NivelAlertaDTO> listar(@RequestParam(required = false) String codigo, Pageable pageable) {
        return service.listar(codigo, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelAlertaDTO> buscarPorId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NivelAlertaDTO> salvar(@RequestBody @Valid NivelAlertaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NivelAlertaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid NivelAlertaDTO dto) {
        return service.update(id, dto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    
    @GetMapping("/codigo-exato")
    public ResponseEntity<NivelAlertaDTO> buscarPorCodigoExato(@RequestParam String codigo) {
        return service.findByCodigoExato(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @GetMapping("/contar-alertas")
    public ResponseEntity<Long> contarAlertas(@RequestParam Long id) {
        Long count = service.contarAlertas(id);
        if (count == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(count);
    }
}