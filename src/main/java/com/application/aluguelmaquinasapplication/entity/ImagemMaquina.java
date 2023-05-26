package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "imagens_maquina")
public class ImagemMaquina {
    
    @Id
    private Integer id;
    private String nome;
    private String tipo;
    private Long tamanho;
    private String conteudo;
    @ManyToOne
    @JoinColumn(name = "id_maquina")
    private Maquina maquina;

}
