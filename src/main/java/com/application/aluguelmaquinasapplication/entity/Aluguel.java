package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Inheritance
public final class Aluguel extends AbstractEntity {

    @NotNull
    private LocalDate dataDevolucao;
    private BigDecimal multa;
    @NotNull
    private BigDecimal valorTotal;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}
