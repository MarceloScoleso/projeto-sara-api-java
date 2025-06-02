package com.projetosara.sara_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeituraSensorDTO {
    private Long id;
    private SensorDTO sensor;
    private Double valor;
    private String unidade;
    private LocalDateTime dataHora;
}
