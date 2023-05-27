package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.entity.Categoria;

public interface CategoriaService {

    void salvar(Categoria categoria);
    void atualizar(Categoria categoria);
    Categoria consultarPorId(long id);
    List<Categoria> consultarTodos();
    void deletar(Long id);
    
    
}
