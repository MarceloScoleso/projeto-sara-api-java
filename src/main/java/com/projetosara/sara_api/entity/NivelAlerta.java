package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String descricao;

    @OneToMany(mappedBy = "nivelAlerta")
    private List<Alerta> alertas;
}
