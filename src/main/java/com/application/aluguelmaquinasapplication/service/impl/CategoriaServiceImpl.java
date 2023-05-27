package com.application.aluguelmaquinasapplication.service.impl;

import com.application.aluguelmaquinasapplication.dto.CategoriaDTO;
import com.application.aluguelmaquinasapplication.entity.Categoria;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.repository.CategoriaRepository;
import com.application.aluguelmaquinasapplication.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public void salvar(CategoriaDTO categoriaDTO) {
        categoriaRepository.save(categoriaDTO.toCategoria());
    }

    @Override
    public void atualizar(CategoriaDTO categoriaDTO) {
        final var categoria = categoriaRepository.findById(categoriaDTO.())
                .orElseThrow(() -> new NotFoundException("categoria nao encontrada"));

        categoria.setNome(categoriaDTO.nome());

        categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaDTO consultarPorId(Long id) {
        final var categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("categoria nao encontrada"));
        return CategoriaDTO.fromCategoria(categoria);
    }

    @Override
    public List<CategoriaDTO> consultarTodos() {
        return categoriaRepository.findAll().stream().map(CategoriaDTO::fromCategoria).toList();
    }

    @Override
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

}
