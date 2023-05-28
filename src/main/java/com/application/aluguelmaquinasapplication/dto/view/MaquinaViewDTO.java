package com.application.aluguelmaquinasapplication.dto.view;

import com.application.aluguelmaquinasapplication.dto.CategoriaDTO;
import com.application.aluguelmaquinasapplication.dto.MaquinaDTO;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record MaquinaViewDTO(
        Long id,
        String titulo,
        String descricao,

        @NumberFormat
        BigDecimal valorDiaria,
        Long idCategoria,
        String categoria
) {

    public static MaquinaViewDTO empty() {

        return new MaquinaViewDTO (
                null,
                null,
                null,
                null,
                null,
                null
        );

    }

    public MaquinaDTO toMaquinaDTO() {

        return new MaquinaDTO(
                this.id,
                this.titulo,
                this.descricao,
                this.valorDiaria,
                new CategoriaDTO(this.idCategoria, this.categoria)
        );

    }

    public static MaquinaViewDTO fromMaquinaDTO(MaquinaDTO maquinaDTO) {

        return new MaquinaViewDTO (
                maquinaDTO.id(),
                maquinaDTO.titulo(),
                maquinaDTO.descricao(),
                maquinaDTO.valorDiaria(),
                maquinaDTO.categoria().id(),
                maquinaDTO.categoria().nome()
        );

    }

}
