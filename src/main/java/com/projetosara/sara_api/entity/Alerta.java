package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {

    @Id
    @Column(name = "ID_ALERTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "nivel_alerta_id")
    private NivelAlerta nivelAlerta;

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    @Column(name = "DATA_HORA")
    private LocalDateTime dataHora;
}