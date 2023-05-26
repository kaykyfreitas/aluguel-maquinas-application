package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Inheritance
public final class AvaliacaoMaquina extends AbstractEntity {

    @Lob
    @NotNull
    private String descricao;
    @NotNull
    private Float avaliacao;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}
