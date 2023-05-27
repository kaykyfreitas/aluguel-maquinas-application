package com.application.aluguelmaquinasapplication.controller;

import com.application.aluguelmaquinasapplication.dto.view.CategoriaViewDTO;
import com.application.aluguelmaquinasapplication.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/create")
    public ModelAndView createView() {
        final var modelAndView = new ModelAndView("create-category");
        modelAndView.addObject("categoria", CategoriaViewDTO.empty());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(CategoriaViewDTO categoriaViewDTO) {
        if (Objects.nonNull(categoriaViewDTO.id())) {
            categoriaService.atualizar(categoriaViewDTO.toCategoriaDTO());
        } else {
            categoriaService.salvar(categoriaViewDTO.toCategoriaDTO());
        }

        return "redirect:/categoria/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        final var modelAndView = new ModelAndView("list-category");
        modelAndView.addObject(
                "categorias",
                categoriaService.consultarTodos().stream().map(CategoriaViewDTO::fromCategoriaDTO).toList()
        );
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        final var modelAndView  = new ModelAndView("create-category");
        modelAndView.addObject(
                "categoria",
                CategoriaViewDTO.fromCategoriaDTO(categoriaService.consultarPorId(id))
        );
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoriaService.deletar(id);
        return "redirect:/categoria/list";
    }

}
