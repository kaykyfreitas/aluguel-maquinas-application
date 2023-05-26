package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Inheritance
public final class ImagemMaquina extends AbstractEntity {

    @NotNull
    @Size(max = 100)
    private String nome;
    @NotNull
    @Size(max = 5)
    private String tipo;
    @NotNull
    private Long tamanho;
    @Lob
    @NotNull
    private String conteudo;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_maquina")
    private Maquina maquina;

}
