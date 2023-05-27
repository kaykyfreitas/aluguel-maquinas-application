package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.entity.Maquina;

public interface MaquinaService {

    void salvar(Maquina maquina);
    Maquina consultarPorId(Long id);
    List<Maquina> consultarTodos();
    void atualizar(Maquina maquina);
    void deletar(Long id);
    

    
}
