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
    private Long id;

    private String codigo;
    private String descricao;

    @OneToMany(mappedBy = "tipoSensor")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Sensor> sensores;
}
