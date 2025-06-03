package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TIPOSENSOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_SENSOR")
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "tipoSensor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Sensor> sensores;
}