package com.application.aluguelmaquinasapplication.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import com.application.aluguelmaquinasapplication.entity.Reserva;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.repository.ReservaRepository;
import com.application.aluguelmaquinasapplication.service.ReservaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public void reservar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    @Override
    public void cancelar(Long id) {
        var reserva = reservaRepository.findById(id).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
        reserva.setDataCancelamento(LocalDate.now());
        reservaRepository.save(reserva);
    }

    @Override
    public void alterar(Reserva reservaDTO) {
        var reserva = reservaRepository.findById(reservaDTO.getId()).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
        
        reserva.setDataRetirada(reservaDTO.getDataRetirada());
        reserva.setDataPrevDevolucao(reservaDTO.getDataPrevDevolucao());
        reserva.setMaquina(reservaDTO.getMaquina());
        
        reservaRepository.save(reserva);
    }

    @Override
    public Reserva consultarPorId(Long id) {
        return reservaRepository.findById(id).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
    }

    @Override
    public List<Reserva> consultaTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public List<Reserva> consultarPorMaquina(Long idMaquina) {
//        return reservaRepository.findAllByMaquina_Id(idMaquina);
        return null;
    }

    @Override
    public List<Reserva> consultarPorUsuario(Long idUsuario) {
//        return reservaRepository.findAllByUsuario_Id(idUsuario);
        return null;
    }


    @Override
    public List<Reserva> consultarReservasCanceladas() {
//        return reservaRepository.findAllReservasAbertas();
        return null;
    }

    @Override
    public List<Reserva> consultarReservasAbertas() {
//      return reservaRepository.findAllReservasAbertas();
        return null;
    }

    @Override
    public List<Reserva> consultarReservasFechadas() {
//        return reservaRepository.findAllReservasFechadas();
        return null;
    }


    
}
