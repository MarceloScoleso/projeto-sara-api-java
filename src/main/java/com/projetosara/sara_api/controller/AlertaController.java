package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.dto.AlertaDTO;
import com.projetosara.sara_api.service.AlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
public class AlertaController {
    private final AlertaService service;

    @GetMapping
    public Page<AlertaDTO> listar(@RequestParam(required = false) String titulo, Pageable pageable) {
        return service.listar(titulo, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertaDTO> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-nivel")
    public Page<AlertaDTO> buscarPorNivelAlerta(@RequestParam Long nivelAlertaId, Pageable pageable) {
        return service.buscarPorNivelAlerta(nivelAlertaId, pageable);
    }

    @GetMapping("/por-periodo")
    public Page<AlertaDTO> buscarPorIntervaloDeDatas(
            @RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicio,
            @RequestParam("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFim,
            Pageable pageable) {
        return service.buscarPorIntervaloDeDatas(dataInicio, dataFim, pageable);
    }

    @PostMapping
    public ResponseEntity<AlertaDTO> salvar(@RequestBody @Valid AlertaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AlertaDTO dto) {
        return service.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
