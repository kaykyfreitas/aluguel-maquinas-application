package com.application.aluguelmaquinasapplication.dto.view;

import org.springframework.core.io.Resource;

import java.util.List;

public record ImagensMaquinaViewDTO(
        List<Resource> arquivos
) {
}
