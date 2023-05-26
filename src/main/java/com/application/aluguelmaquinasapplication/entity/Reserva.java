package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    private Integer id;
    private LocalDate dataReserva;
    private LocalDate dataRetirada;
    private LocalDate prevDevolucao;
    @ManyToOne
    @JoinColumn(name = "cpf_usuario")
    private Usuario usuario;
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
