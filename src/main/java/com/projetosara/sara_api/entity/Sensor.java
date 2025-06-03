package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "SENSOR") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SENSOR") 
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TIPO_SENSOR_ID") 
    private TipoSensor tipoSensor;

    @ManyToOne
    @JoinColumn(name = "LOCALIZACAO_ID") 
    private Localizacao localizacao;

    @OneToMany(mappedBy = "sensor")
    private List<LeituraSensor> leituras;
}
