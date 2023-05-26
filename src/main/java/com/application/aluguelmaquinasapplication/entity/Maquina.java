package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Inheritance
public final class Maquina extends AbstractEntity {

    @NotNull
    @Size(max = 80)
    private String titulo;
    @Lob
    @NotNull
    private String descricao;
    @NotNull
    private BigDecimal valorDiaria;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "maquina", fetch = FetchType.LAZY)
    private List<ImagemMaquina> imagensMaquina = new ArrayList<>();
    @OneToMany(mappedBy = "maquina", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

}
