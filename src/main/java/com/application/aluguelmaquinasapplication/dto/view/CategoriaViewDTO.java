package com.application.aluguelmaquinasapplication.dto.view;

import com.application.aluguelmaquinasapplication.dto.CategoriaDTO;

public record CategoriaViewDTO(
        Long id,
        String nome
) {

    public static CategoriaViewDTO empty() {

        return new CategoriaViewDTO(null, null);

    }

    public CategoriaDTO toCategoriaDTO() {

        return new CategoriaDTO(this.id, this.nome);

    }

    public static CategoriaViewDTO fromCategoriaDTO(CategoriaDTO categoriaDTO) {

        return new CategoriaViewDTO(categoriaDTO.id(), categoriaDTO.nome());

    }

}
