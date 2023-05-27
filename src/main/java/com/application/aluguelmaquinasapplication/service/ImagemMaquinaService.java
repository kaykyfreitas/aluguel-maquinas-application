package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.entity.ImagemMaquina;

public interface ImagemMaquinaService {


    void salvarImagem(ImagemMaquina imagemMaquina);
    void deletarImagem(Long id);
    ImagemMaquina consultarImagemPorId(Long id);
    List<ImagemMaquina> consultarImagensPorMaquina(Long idMaquina);
    
    
}
