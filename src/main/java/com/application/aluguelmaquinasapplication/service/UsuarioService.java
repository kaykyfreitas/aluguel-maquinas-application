package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.UsuarioDTO;

public interface UsuarioService {
    
    void salvar(UsuarioDTO usuarioDTO);
    UsuarioDTO consultarPorId(Long id);
    List<UsuarioDTO> consultarTodos();
    void atualizar(UsuarioDTO usuarioDTO);
    void deletar(Long id);
    
}
