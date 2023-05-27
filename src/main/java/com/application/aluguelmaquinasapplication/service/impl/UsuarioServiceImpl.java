package com.application.aluguelmaquinasapplication.service.impl;

import com.application.aluguelmaquinasapplication.dto.UsuarioDTO;
import com.application.aluguelmaquinasapplication.entity.Endereco;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.repository.UsuarioRepository;
import com.application.aluguelmaquinasapplication.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public void salvar(UsuarioDTO usuarioDTO) {
        // Convertendo DTO
        final var usuario = usuarioDTO.toUsuario();
        final var endereco = usuarioDTO.endereco().toEndereco();

        // Mapeando entidades
        usuario.setEndereco(endereco);
        endereco.setUsuario(usuario);

        // Pesistindo entidades
        this.usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDTO consultarPorId(Long id) {
        final var usuario =  usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("usuario nao encontrado"));
        return UsuarioDTO.fromUsuario(usuario);
    }

    @Override
    public List<UsuarioDTO> consultarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioDTO::fromUsuario).toList();
    }

    @Override
    @Transactional
    public void atualizar(UsuarioDTO usuarioDTO) {
        final var usuario = usuarioRepository.findById(usuarioDTO.id())
                .orElseThrow(() -> new NotFoundException("usuario nao encontrado"));

        usuario.setCpf(usuarioDTO.cpf());
        usuario.setNome(usuarioDTO.nome());
        usuario.setEmail(usuarioDTO.email());
        usuario.setTelefone(usuarioDTO.telefone());
        usuario.setSenha(usuarioDTO.senha());

        Endereco endereco = usuario.getEndereco();
        endereco.setUf(usuarioDTO.endereco().uf());
        endereco.setCep(usuarioDTO.endereco().cep());
        endereco.setRua(usuarioDTO.endereco().rua());
        endereco.setNumero(usuarioDTO.endereco().numero());
        endereco.setBairro(usuarioDTO.endereco().bairro());
        endereco.setCidade(usuarioDTO.endereco().cidade());

        usuarioRepository.save(usuario);
    }

    @Override
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

}