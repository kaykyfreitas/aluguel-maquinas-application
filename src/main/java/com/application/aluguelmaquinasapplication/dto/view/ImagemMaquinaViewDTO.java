package com.application.aluguelmaquinasapplication.dto.view;

import com.application.aluguelmaquinasapplication.dto.ImagemMaquinaDTO;
import org.springframework.web.multipart.MultipartFile;

public record ImagemMaquinaViewDTO(
        Long id,
        Long idMaquina,
        MultipartFile arquivo

) {

    public static ImagemMaquinaViewDTO empty() {

        return new ImagemMaquinaViewDTO(null, null, null);

    }

    public ImagemMaquinaDTO toImagemMaquinaDTO() {

        return new ImagemMaquinaDTO(this.id, this.idMaquina, this.arquivo);

    }

    public static ImagemMaquinaViewDTO fromImagemMaquinaDTO(ImagemMaquinaDTO imagemMaquinaDTO) {

        return new ImagemMaquinaViewDTO(imagemMaquinaDTO.id(), imagemMaquinaDTO.idMaquina(), imagemMaquinaDTO.arquivo());

    }


}
