package com.application.aluguelmaquinasapplication.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import com.application.aluguelmaquinasapplication.dto.ReservaDTO;
import com.application.aluguelmaquinasapplication.entity.Reserva;
import com.application.aluguelmaquinasapplication.exception.NotFoundException;
import com.application.aluguelmaquinasapplication.exception.ValidacaoException;
import com.application.aluguelmaquinasapplication.repository.ReservaRepository;
import com.application.aluguelmaquinasapplication.service.ReservaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl extends ValidacaoService<Reserva> implements ReservaService{

    private final ReservaRepository reservaRepository;

    @Override
    protected void validarObjeto(Reserva obj){
        super.validarObjeto(obj);
        if (Objects.isNull(obj.getDataPrevDevolucao()))
            throw new ValidacaoException("data reserva nulo");
    }

    @Override
    public void reservar(ReservaDTO reservaDTO) {
    
        final var reserva = reservaDTO.toReserva();
        this.validarObjeto(reserva);
        reserva.setDataReserva(LocalDate.now());
        reservaRepository.save(reserva);
    }

    @Override
    public void cancelar(Long id) {
        var reserva = reservaRepository.findById(id).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
        reserva.setDataCancelamento(LocalDate.now());
        reservaRepository.save(reserva);
    }

    @Override
    public void alterar(ReservaDTO reservaDTO) {
        var reserva = reservaRepository.findById(reservaDTO.id()).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
        
        reserva.setDataRetirada(reservaDTO.dataRetirada());
        reserva.setDataPrevDevolucao(reservaDTO.dataPrevDevolucao());
        reserva.setMaquina(reservaDTO.maquina().toMaquinaSemCategoria());
        
        reservaRepository.save(reserva);
    }

    @Override
    public ReservaDTO consultarPorId(Long id) {
        final var reserva = reservaRepository.findById(id).orElseThrow(()-> new NotFoundException("reserva nao encontrada"));
        return ReservaDTO.fromReserva(reserva);
    }

    @Override
    public List<ReservaDTO> consultaTodas() {
        return reservaRepository.findAll().stream().map(ReservaDTO::fromReserva).toList();
    }

    @Override
    public List<ReservaDTO> consultarPorMaquina(Long idMaquina) {
//        return reservaRepository.findAllByMaquina_Id(idMaquina);
        return null;
    }

    @Override
    public List<ReservaDTO> consultarPorUsuario(Long idUsuario) {
//        return reservaRepository.findAllByUsuario_Id(idUsuario);
        return null;
    }


//     @Override
//     public List<ReservaDTO> consultarReservasCanceladas() {
// //        return reservaRepository.findAllReservasAbertas();
//         return null;
//     }

//     @Override
//     public List<ReservaDTO> consultarReservasAbertas() {
// //      return reservaRepository.findAllReservasAbertas();
//         return null;
//     }

//     @Override
//     public List<ReservaDTO> consultarReservasFechadas() {
// //        return reservaRepository.findAllReservasFechadas();
//         return null;
//     }


    
}
