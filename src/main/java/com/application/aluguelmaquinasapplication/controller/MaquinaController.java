package com.application.aluguelmaquinasapplication.controller;

import com.application.aluguelmaquinasapplication.dto.view.MaquinaViewDTO;
import com.application.aluguelmaquinasapplication.service.MaquinaService;
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
@RequestMapping("/maquina")
public class MaquinaController {

    private final MaquinaService maquinaService;

    @GetMapping("/create")
    public ModelAndView createView() {
        final var modelAndView = new ModelAndView("create-maquina");
        modelAndView.addObject("maquina", MaquinaViewDTO.empty());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(MaquinaViewDTO maquinaViewDTO) {
        if (Objects.nonNull(maquinaViewDTO.id())) {
            maquinaService.atualizar(maquinaViewDTO.toMaquinaDTO());
        } else {
            maquinaService.salvar(maquinaViewDTO.toMaquinaDTO());
        }

        return "redirect:/maquina/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        final var modelAndView = new ModelAndView("list-maquina");
        modelAndView.addObject(
                "maquinas",
                maquinaService.consultarTodos().stream().map(MaquinaViewDTO::fromMaquinaDTO).toList()
        );
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        final var modelAndView  = new ModelAndView("create-maquina");
        modelAndView.addObject(
                "maquina",
                MaquinaViewDTO.fromMaquinaDTO(maquinaService.consultarPorId(id))
        );
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        maquinaService.deletar(id);
        return "redirect:/maquina/list";
    }

}
