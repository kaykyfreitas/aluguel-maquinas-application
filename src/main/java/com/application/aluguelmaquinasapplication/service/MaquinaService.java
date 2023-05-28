package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.MaquinaDTO;
import com.application.aluguelmaquinasapplication.entity.Maquina;

public interface MaquinaService {

    void salvar(MaquinaDTO maquinaDTO);
    MaquinaDTO consultarPorId(Long id);
    List<MaquinaDTO> consultarTodos();
    void atualizar(MaquinaDTO maquina);
    void deletar(Long id);
    

    
}
