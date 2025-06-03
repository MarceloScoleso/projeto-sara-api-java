package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {

    @Id
    @Column(name = "ID_NOTIFICACAO") 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "alerta_id")
    private Alerta alerta;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusNotificacao status;

    private Date dataEnvio;
}