package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.CategoriaDTO;
import com.application.aluguelmaquinasapplication.entity.Categoria;

public interface CategoriaService {

    void salvar(CategoriaDTO categoriaDTO);
    void atualizar(CategoriaDTO categoriaDTO);
    CategoriaDTO consultarPorId(Long id);
    List<CategoriaDTO> consultarTodos();
    void deletar(Long id);
    
    
}
