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
    private LocalDate dataCancelamento;
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

    public Reserva(){
        
    }

    public Reserva(Long id, LocalDate dataReserva, LocalDate dataRetirada, LocalDate dataPrevDevolucao,
    LocalDate dataCancelamento, Usuario usuario, Maquina maquina) {
        this.id = id;
        this.dataReserva = dataReserva;
        this.dataRetirada = dataRetirada;
        this.dataPrevDevolucao = dataPrevDevolucao;
        this.dataCancelamento = dataCancelamento;
        this.usuario = usuario;
        this.maquina = maquina;
    }

}
