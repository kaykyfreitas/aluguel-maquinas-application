package com.application.aluguelmaquinasapplication.controller;

import com.application.aluguelmaquinasapplication.dto.view.ImagemMaquinaViewDTO;
import com.application.aluguelmaquinasapplication.dto.view.MaquinaViewDTO;
import com.application.aluguelmaquinasapplication.service.ImagemMaquinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/imagem")
public class ImagemMaquinaController {

    private final ImagemMaquinaService imagemMaquinaService;

    @GetMapping("/create")
    public ModelAndView createView() {
        final var modelAndView = new ModelAndView("create-imagem");
        modelAndView.addObject("imagem", ImagemMaquinaViewDTO.empty());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(ImagemMaquinaViewDTO imagemMaquinaViewDTO) {
      imagemMaquinaService.salvarImagem(imagemMaquinaViewDTO.toImagemMaquinaDTO());
        return "redirect:/imagem/maquina/" + imagemMaquinaViewDTO.idMaquina();
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        imagemMaquinaService.deletarImagem(id);
        return "redirect:/maquina/list";
    }


    // TODO adicionar no endpoint rest quando criar
//    @GetMapping("/view/{id}")
//    public ResponseEntity<Resource> vizualize(@PathVariable("id") Long id) {
//        return imagemMaquinaService.visualizeFile(id);
//    }

    @GetMapping("/maquina/{id}")
    public ModelAndView listarPorMaquina(@PathVariable("id") Long idMaquina) {
        final var modelAndView  = new ModelAndView("list-imagem");
        modelAndView.addObject("imagens", imagemMaquinaService.consultarImagensPorMaquina(idMaquina));
        return modelAndView;
    }

}
