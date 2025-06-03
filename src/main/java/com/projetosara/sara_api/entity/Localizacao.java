package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "LOCALIZACAO")
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOCALIZACAO")
    private Long id;

    private String cidade;
    private String estado;

    @OneToMany(mappedBy = "localizacao")
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "localizacao")
    private List<Alerta> alertas;
}