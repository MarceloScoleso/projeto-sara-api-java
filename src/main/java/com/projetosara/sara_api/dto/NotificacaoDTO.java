package com.projetosara.sara_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacaoDTO {
    private Long id;
    private UsuarioDTO usuario;
    private AlertaDTO alerta;
    private StatusNotificacaoDTO status;
    private LocalDateTime dataEnvio;
}
