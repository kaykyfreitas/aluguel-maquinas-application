package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.entity.AvaliacaoMaquina;
import com.application.aluguelmaquinasapplication.entity.Endereco;
import com.application.aluguelmaquinasapplication.entity.Usuario;

public interface UsuarioService {
    
    void salvar(Usuario usuario);
    Usuario consultarPorId(Integer id);
    List<Usuario> consultarTodos();
    void atualizar(Usuario usuario);
    void deletar(Long id);
    void atualizarEndereco(Endereco endereco);
    
}
