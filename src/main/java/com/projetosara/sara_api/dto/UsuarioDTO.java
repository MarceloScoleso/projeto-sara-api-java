package com.projetosara.sara_api.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private TipoUsuarioDTO tipoUsuario;
}
