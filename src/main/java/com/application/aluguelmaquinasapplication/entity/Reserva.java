package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Inheritance
public final class Reserva extends AbstractEntity {

    @NotNull
    private LocalDate dataReserva;
    @NotNull
    private LocalDate dataRetirada;
    @NotNull
    private LocalDate dataPrevDevolucao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_maquina")
    private Maquina maquina;

    @OneToOne(mappedBy = "reserva")
    private Aluguel aluguel;
    @OneToOne(mappedBy = "reserva")
    private AvaliacaoUsuario avaliacaoUsuario;
    @OneToOne(mappedBy = "reserva")
    private AvaliacaoMaquina avaliacaoMaquina; 

}
