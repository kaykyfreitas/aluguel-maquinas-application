package com.application.aluguelmaquinasapplication.dto;

import com.application.aluguelmaquinasapplication.entity.Reserva;
import com.application.aluguelmaquinasapplication.entity.Usuario;

import java.time.LocalDate;

public record ReservaDTO(
        Long id,
        LocalDate dataReserva,
        LocalDate dataRetirada,
        LocalDate dataPrevDevolucao,
        LocalDate dataCancelamento,
        UsuarioDTO usuario,
        MaquinaDTO maquina
) {
    public static ReservaDTO fromReserva(Reserva reserva) {

        return new ReservaDTO(
            reserva.getId(),
            reserva.getDataReserva(),
            reserva.getDataRetirada(),
            reserva.getDataPrevDevolucao(),
            reserva.getDataCancelamento(),
            UsuarioDTO.fromUsuario(reserva.getUsuario()),
            MaquinaDTO.fromMaquina(reserva.getMaquina())
        );
         

    }

    public  Reserva toReserva() {

        return new Reserva(
                this.id,
                this.dataReserva,
                this.dataRetirada,
                this.dataPrevDevolucao,                
                this.dataCancelamento,
                this.usuario.toUsuarioSemEndereco(),
                this.maquina.toMaquinaSemCategoria()
        );

    }
 }