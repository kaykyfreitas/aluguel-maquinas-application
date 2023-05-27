package com.application.aluguelmaquinasapplication.dto;

import java.io.InputStream;

public record ImagemMaquinaDTO(
        InputStream arquivo,
        String nome
) { }
