package com.application.aluguelmaquinasapplication.controller;

import com.application.aluguelmaquinasapplication.dto.view.UsuarioViewDTO;
import com.application.aluguelmaquinasapplication.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/create")
    public ModelAndView createView() {
        final var modelAndView = new ModelAndView("create-user");
        modelAndView.addObject("usuario", UsuarioViewDTO.empty());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(UsuarioViewDTO usuarioViewDTO) {
        if (Objects.nonNull(usuarioViewDTO.id())) {
            usuarioService.atualizar(usuarioViewDTO.toUsuarioDTO());
        } else {
            usuarioService.salvar(usuarioViewDTO.toUsuarioDTO());
        }

        return "redirect:/usuario/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        final var modelAndView = new ModelAndView("list-user");
        modelAndView.addObject(
                "usuarios",
                usuarioService.consultarTodos().stream().map(UsuarioViewDTO::fromUsuarioDTO).toList()
        );
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        final var modelAndView  = new ModelAndView("create-user");
        modelAndView.addObject(
                "usuario",
                UsuarioViewDTO.fromUsuarioDTO(usuarioService.consultarPorId(id))
        );
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        usuarioService.deletar(id);
        return "redirect:/usuario/list";
    }

}
