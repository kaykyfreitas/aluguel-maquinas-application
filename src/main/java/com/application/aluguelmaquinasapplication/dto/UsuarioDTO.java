package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.Usuario;

public record UsuarioDTO(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone,
        String senha,
        EnderecoDTO endereco
) {

    public static UsuarioDTO fromUsuario(Usuario usuario) {

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getSenha(),
                EnderecoDTO.fromEndereco(usuario.getEndereco())
        );

    }

    public Usuario toUsuario() {

        return new Usuario(
                this.id,
                this.cpf,
                this.nome,
                this.email,
                this.telefone,
                this.senha,
                this.endereco.toEndereco()
        );

    }

}
