package com.application.aluguelmaquinasapplication.service;

import com.application.aluguelmaquinasapplication.entity.AvaliacaoMaquina;
import com.application.aluguelmaquinasapplication.entity.AvaliacaoUsuario;

public interface AvaliacaoService {

    AvaliacaoUsuario consultarAvaliacoUsuario(Long idUsuario);
    AvaliacaoMaquina consultarAvaliacaoMaquina(long idMaquina);
    void avaliarMaquina(AvaliacaoMaquina avaliacaoMaquina);
    void avaliarUsuario(AvaliacaoUsuario avaliacaoUsuario);
    
}
