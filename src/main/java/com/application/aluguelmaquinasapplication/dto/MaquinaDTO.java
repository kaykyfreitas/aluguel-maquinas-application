package com.application.aluguelmaquinasapplication.dto;

import java.math.BigDecimal;

public record MaquinaDTO(
        String titulo,
        String descricao,
        BigDecimal valorDiaria,
        String categoria
) { }