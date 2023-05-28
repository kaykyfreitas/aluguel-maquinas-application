package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.Maquina;

import java.math.BigDecimal;

public record MaquinaDTO(
        Long id,
        String titulo,
        String descricao,
        BigDecimal valorDiaria,
        CategoriaDTO categoria
) {

    public static MaquinaDTO fromMaquina(Maquina maquina) {

        return new MaquinaDTO (
                maquina.getId(),
                maquina.getTitulo(),
                maquina.getDescricao(),
                maquina.getValorDiaria(),
                CategoriaDTO.fromCategoria(maquina.getCategoria())
        );

    }

    public Maquina toMaquina() {

        return new Maquina(
                this.id,
                this.titulo,
                this.descricao,
                this.valorDiaria,
                this.categoria.toCategoria()
        );

    }

}