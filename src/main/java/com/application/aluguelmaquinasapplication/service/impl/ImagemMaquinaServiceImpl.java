package com.application.aluguelmaquinasapplication.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.application.aluguelmaquinasapplication.dto.ImagemMaquinaDTO;
import com.application.aluguelmaquinasapplication.entity.ImagemMaquina;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.repository.ImagemMaquinaRepository;
import com.application.aluguelmaquinasapplication.service.ImagemMaquinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Service
@RequiredArgsConstructor
public class ImagemMaquinaServiceImpl implements ImagemMaquinaService {

    private final ImagemMaquinaRepository imagemMaquinaRepository;

    @Override
    public void salvarImagem(ImagemMaquinaDTO imagemMaquinaDTO) {
        imagemMaquinaRepository.save(imagemMaquinaDTO.toImagemMaquina());
    }

    @Override
    public void deletarImagem(Long id) {
        imagemMaquinaRepository.deleteById(id);
    }

    @Override
    public String consultarImagemPorId(Long id) {
        final var imagemMaquina = imagemMaquinaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("imagem nao encontrada"));

        Resource imageResource = new ByteArrayResource(imagemMaquina.getConteudo());

        byte[] imageBytes = new byte[0];
        try {
            imageBytes = StreamUtils.copyToByteArray(imageResource.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return java.util.Base64.getEncoder().encodeToString(imageBytes);
    }

    @Override
    public List<String> consultarImagensPorMaquina(Long idMaquina) {
        List<ImagemMaquina> imagemMaquinas = imagemMaquinaRepository.findByMaquina_Id(idMaquina);
        List<Resource> resources = new ArrayList<>();
        List<String> bases64 = new ArrayList<>();

        imagemMaquinas.forEach(imagem -> {
            Resource imageResource = new ByteArrayResource(imagem.getConteudo());
            resources.add(imageResource);
        });

        resources.forEach(resource -> {
            byte[] imageBytes = new byte[0];
            try {
                imageBytes = StreamUtils.copyToByteArray(resource.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String base64Image = java.util.Base64.getEncoder().encodeToString(imageBytes);
            bases64.add(base64Image);
        });

        return bases64;
    }
}
