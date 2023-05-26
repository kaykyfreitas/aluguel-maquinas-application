package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "avaliacao_usuario")
public class AvaliacaoUsuario {
    
    @Id
    private Integer id;
    private String descricao;
    private Float avaliacao;
    @OneToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

}
