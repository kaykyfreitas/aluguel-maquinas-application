package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    private Integer id;
    private LocalDate dataDevolucao;
    private BigDecimal multa;
    private BigDecimal valorTotal;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}
