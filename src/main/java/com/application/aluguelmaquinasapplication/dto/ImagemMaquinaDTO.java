package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.ImagemMaquina;
import com.application.aluguelmaquinasapplication.entity.Maquina;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public record ImagemMaquinaDTO(
        Long id,
        Long idMaquina,
        MultipartFile arquivo

) {

//    public static ImagemMaquinaDTO fromImagemMaquina(ImagemMaquina imagemMaquina) {
//
//        return new ImagemMaquinaDTO(
//                imagemMaquina.getId(),
//                imagemMaquina.getMaquina().getId()
//        );
//
//    }

    public ImagemMaquina toImagemMaquina() {

        try {
            return new ImagemMaquina(
                    this.arquivo.getOriginalFilename(),
                    this.arquivo.getContentType(),
                    this.arquivo.getSize(),
                    this.arquivo.getBytes(),
                    this.idMaquina
            );
        } catch (IOException e) {
            throw new RuntimeException("error getting file bytes");
        }

    }

}
