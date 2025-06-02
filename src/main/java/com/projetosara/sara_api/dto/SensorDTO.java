package com.projetosara.sara_api.dto;

import lombok.Data;

@Data
public class SensorDTO {
    private Long id;
    private TipoSensorDTO tipoSensor;
    private LocalizacaoDTO localizacao;
}
