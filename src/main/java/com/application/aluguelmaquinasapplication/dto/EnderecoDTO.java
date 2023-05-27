package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.Endereco;

public record EnderecoDTO(
        String cep,
        String rua,
        Long numero,
        String cidade,
        String bairro,
        String uf
) {

    public static EnderecoDTO fromEndereco(Endereco endereco) {

        return new EnderecoDTO(
                endereco.getCep(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getBairro(),
                endereco.getUf()
        );

    }

    public Endereco toEndereco() {

        return new Endereco(
                this.cep,
                this.rua,
                this.numero,
                this.cidade,
                this.bairro,
                this.uf
        );

    }

}