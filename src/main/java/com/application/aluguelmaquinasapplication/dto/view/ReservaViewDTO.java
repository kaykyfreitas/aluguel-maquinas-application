package com.application.aluguelmaquinasapplication.dto.view;

import java.time.LocalDate;

import com.application.aluguelmaquinasapplication.dto.MaquinaDTO;
import com.application.aluguelmaquinasapplication.dto.ReservaDTO;
import com.application.aluguelmaquinasapplication.dto.UsuarioDTO;

public record ReservaViewDTO(
        Long id,
        LocalDate dataReserva,
        LocalDate dataRetirada,
        LocalDate dataPrevDevolucao,
        LocalDate dataCancelamento,
        Long idUsuario,
        Long idMaquina
) {

    public static ReservaViewDTO empty() {

        return new ReservaViewDTO(
                null,
                null,
                null,
                null,
                null,
                null,
                null
              
        );

    }

    public ReservaDTO toReservaDTO() {

        return new ReservaDTO (
                this.id,
                this.dataReserva,
                this.dataRetirada,
                this.dataPrevDevolucao,
                this.dataCancelamento,
                new UsuarioDTO(this.idUsuario,
                        null,
                        null, 
                        null, 
                        null, 
                        null, 
                        null),
                new MaquinaDTO(this.idMaquina, null, null, null, null)
        );

    }

    public static ReservaViewDTO fromReservaDTO(ReservaDTO reservaDTO) {

        return new ReservaViewDTO(
               reservaDTO.id(),
               reservaDTO.dataReserva(),
               reservaDTO.dataRetirada(),
               reservaDTO.dataPrevDevolucao(),
               reservaDTO.dataCancelamento(),
               reservaDTO.usuario().id(),
               reservaDTO.maquina().id()
        );

    }
}
