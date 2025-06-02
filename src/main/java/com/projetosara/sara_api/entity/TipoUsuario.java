package com.projetosara.sara_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TIPOUSUARIO")
public class TipoUsuario {

    @Id
    @Column(name = "ID_TIPO_USUARIO")
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
}