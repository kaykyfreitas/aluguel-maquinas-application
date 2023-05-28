package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.ImagemMaquinaDTO;

public interface ImagemMaquinaService {


    void salvarImagem(ImagemMaquinaDTO imagemMaquinaDTO);
    void deletarImagem(Long id);
    String consultarImagemPorId(Long id);
    List<String> consultarImagensPorMaquina(Long idMaquina);
    
}
