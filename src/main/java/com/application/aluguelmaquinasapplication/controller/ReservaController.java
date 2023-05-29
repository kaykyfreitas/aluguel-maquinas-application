package com.application.aluguelmaquinasapplication.controller;


import com.application.aluguelmaquinasapplication.dto.view.ReservaViewDTO;
import com.application.aluguelmaquinasapplication.dto.view.UsuarioViewDTO;
import com.application.aluguelmaquinasapplication.service.ReservaService;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    @GetMapping("/create")
    public ModelAndView createView() {
        final var modelAndView = new ModelAndView("create-reserva");
        modelAndView.addObject("reserva", ReservaViewDTO.empty());
        return modelAndView;
    }

    @PostMapping("/create")
    public String salvar(ReservaViewDTO reservaViewDTO){
        System.out.println(reservaViewDTO);
        if(Objects.nonNull(reservaViewDTO.id())){
            reservaService.alterar(reservaViewDTO.toReservaDTO());
        }else{
            reservaService.reservar(reservaViewDTO.toReservaDTO());
        }

        return "redirect:/reserva/list";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        final var modelAndView = new ModelAndView("list-reserva");
        modelAndView.addObject(
                "reservas",
                reservaService.consultaTodas().stream().map(ReservaViewDTO::fromReservaDTO).toList()
        );
        return modelAndView;
    }

    @GetMapping("/cancelar/{id}")
    public String delete(@PathVariable("id") Long id) {
        reservaService.cancelar(id);
        return "redirect:/reserva/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        final var modelAndView  = new ModelAndView("create-reserva");
        modelAndView.addObject(
                "reserva",
                ReservaViewDTO.fromReservaDTO(reservaService.consultarPorId(id))
        );
        return modelAndView;
    }
}
