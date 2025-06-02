package com.projetosara.sara_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlertaDTO {
    private Long id;
    private UsuarioDTO usuario;
    private String mensagem;
    private NivelAlertaDTO nivelAlerta;
    private LocalizacaoDTO localizacao;
    private LocalDateTime dataHora;
}
