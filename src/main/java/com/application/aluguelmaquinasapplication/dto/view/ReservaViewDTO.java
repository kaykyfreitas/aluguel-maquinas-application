package com.application.aluguelmaquinasapplication.dto.view;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.NumberFormat;

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
        Long idMaquina,
        String cpfUsuario,
        String nomeMaquina,
        
        @NumberFormat
        BigDecimal valorDiaria
) {

    public static ReservaViewDTO empty() {

        return new ReservaViewDTO(
                null,
                null,
                null,
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
               reservaDTO.maquina().id(),
               reservaDTO.usuario().cpf(),
               reservaDTO.maquina().titulo(),
               reservaDTO.maquina().valorDiaria()
        );

    }
}
