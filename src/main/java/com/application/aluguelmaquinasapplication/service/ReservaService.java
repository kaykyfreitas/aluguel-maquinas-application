package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.entity.AvaliacaoUsuario;
import com.application.aluguelmaquinasapplication.entity.Reserva;

public interface ReservaService {

    void reservar(Reserva reserva);
    void cancelar(Long id);
    void alterar(Reserva reserva);
    Reserva consultarPorId(Long id);
    List<Reserva> consultaTodas();
    List<Reserva> consultarPorMaquina(Long idMaquina);
    List<Reserva> consultarPorUsuario(Long idUsuario);
    List<Reserva> consultarReservasAtivas();
    List<Reserva> consultarReservasCanceladas();
    List<Reserva> consultarReservasAbertas();
    List<Reserva> consultarReservasFechadas(); 
    

    
}
