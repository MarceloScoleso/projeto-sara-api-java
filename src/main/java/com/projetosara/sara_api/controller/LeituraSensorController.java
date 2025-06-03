package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.dto.LeituraSensorDTO;
import com.projetosara.sara_api.service.LeituraSensorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/leitura-sensores")
@RequiredArgsConstructor
public class LeituraSensorController {
    private final LeituraSensorService service;

    @GetMapping
    public Page<LeituraSensorDTO> listar(@RequestParam(required = false) Long sensorId, Pageable pageable) {
        return service.listar(sensorId, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraSensorDTO> buscarPorId(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<LeituraSensorDTO> salvar(@RequestBody @Valid LeituraSensorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeituraSensorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid LeituraSensorDTO dto) {
        return service.update(id, dto).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ultima")
    public ResponseEntity<LeituraSensorDTO> buscarUltimaLeitura(@RequestParam Long sensorId) {
        return service.buscarUltimaLeitura(sensorId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
