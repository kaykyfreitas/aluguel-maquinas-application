package com.application.aluguelmaquinasapplication.service.impl;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.MaquinaDTO;
import org.springframework.stereotype.Service;

import com.application.aluguelmaquinasapplication.entity.Maquina;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.repository.MaquinaRepository;
import com.application.aluguelmaquinasapplication.service.MaquinaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaquinaServiceImpl implements MaquinaService {

    private final MaquinaRepository maquinaRepository;

    @Override
    public void salvar(MaquinaDTO maquinaDTO) {
        maquinaRepository.save(maquinaDTO.toMaquina());
    }

    @Override
    public MaquinaDTO consultarPorId(Long id) {
        final var maquina = maquinaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("maquina not found"));
        return MaquinaDTO.fromMaquina(maquina);
    }

    @Override
    public List<MaquinaDTO> consultarTodos() {
        return maquinaRepository.findAll().stream().map(MaquinaDTO::fromMaquina).toList();
    }

    @Override
    public void atualizar(MaquinaDTO maquinaDTO) {
        final var maquina = maquinaRepository.findById(maquinaDTO.id())
                .orElseThrow(() -> new NotFoundException("maquina not found"));
        
        maquina.setTitulo(maquinaDTO.titulo());
        maquina.setDescricao(maquinaDTO.descricao());
        maquina.setValorDiaria(maquinaDTO.valorDiaria());
        maquina.setCategoria(maquinaDTO.categoria().toCategoria());

        maquinaRepository.save(maquina);
    }

    @Override
    public void deletar(Long id) {
        maquinaRepository.deleteById(id);
    }
    
}
