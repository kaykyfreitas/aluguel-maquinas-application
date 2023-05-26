package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "maquina")
public class Maquina {

    @Id
    private Integer id;
    private String titulo;
    private String descricao;
    private BigDecimal valorDiaria;
    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "maquina", fetch = FetchType.LAZY)
    private List<ImagemMaquina> imagensMaquina = new ArrayList<>();
    @OneToMany(mappedBy = "maquina", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

}
