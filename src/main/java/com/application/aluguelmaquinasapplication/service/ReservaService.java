package com.application.aluguelmaquinasapplication.service;

import java.util.List;

import com.application.aluguelmaquinasapplication.dto.ReservaDTO;
import com.application.aluguelmaquinasapplication.entity.AvaliacaoUsuario;


public interface ReservaService {

    void reservar(ReservaDTO ReservaDTO);
    void cancelar(Long id);
    void alterar(ReservaDTO ReservaDTO);
    ReservaDTO consultarPorId(Long id);
    List<ReservaDTO> consultaTodas();
    List<ReservaDTO> consultarPorMaquina(Long idMaquina);
    List<ReservaDTO> consultarPorUsuario(Long idUsuario);
    // List<ReservaDTO> consultarReservaDTOsCanceladas();
    // List<ReservaDTO> consultarReservaDTOsAbertas();
    // List<ReservaDTO> consultarReservaDTOsFechadas();

}
