package com.application.aluguelmaquinasapplication.dto;

import java.time.LocalDate;

public record ReservaDTO(
        LocalDate dataReserva,
        LocalDate dataRetirada,
        LocalDate dataPrevDevolucao,
        UsuarioDTO usuario,
        MaquinaDTO maquinaD
) { }