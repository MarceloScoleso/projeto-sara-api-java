package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "LEITURASENSOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeituraSensor {

    @Id
    @Column(name = "ID_LEITURA")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID")
    private Sensor sensor;

    private Double valor;
    private String unidade;

    @Column(name = "DATA_HORA")
    private Date dataHora;
}