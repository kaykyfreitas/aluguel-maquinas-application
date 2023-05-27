package com.application.aluguelmaquinasapplication.dto.view;

import com.application.aluguelmaquinasapplication.dto.EnderecoDTO;
import com.application.aluguelmaquinasapplication.dto.UsuarioDTO;

public record UsuarioViewDTO(
        Long id,
        String cpf,
        String nome,
        String email,
        String telefone,
        String senha,
        String cep,
        String rua,
        Long numero,
        String cidade,
        String bairro,
        String uf
) {

    public static UsuarioViewDTO empty() {

        return new UsuarioViewDTO(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

    }

    public UsuarioDTO toUsuarioDTO() {

        return new UsuarioDTO (
                this.id,
                this.cpf,
                this.nome,
                this.email,
                this.telefone,
                this.senha,
                new EnderecoDTO(
                        this.cep,
                        this.rua,
                        this.numero,
                        this.cidade,
                        this.bairro,
                        this.uf
                )
        );

    }

    public static UsuarioViewDTO fromUsuarioDTO(UsuarioDTO usuarioDTO) {

        return new UsuarioViewDTO(
                usuarioDTO.id(),
                usuarioDTO.cpf(),
                usuarioDTO.nome(),
                usuarioDTO.email(),
                usuarioDTO.telefone(),
                usuarioDTO.senha(),
                usuarioDTO.endereco().cep(),
                usuarioDTO.endereco().rua(),
                usuarioDTO.endereco().numero(),
                usuarioDTO.endereco().cidade(),
                usuarioDTO.endereco().bairro(),
                usuarioDTO.endereco().uf()
        );

    }

}
