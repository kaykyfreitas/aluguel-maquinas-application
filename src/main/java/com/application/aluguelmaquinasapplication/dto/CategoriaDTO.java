package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.Categoria;

public record CategoriaDTO(
        Long id,
        String nome
) {

    public static CategoriaDTO fromCategoria(Categoria categoria) {
        return new CategoriaDTO(categoria.getId(), categoria.getNome());
    }

    public Categoria toCategoria() {
        return new Categoria(this.id, this.nome);
    }

}
