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
    @Size(max = 30)
    private String tipo;
    @NotNull
    private Long tamanho;
    @Lob
    @NotNull
    private byte[] conteudo;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_maquina")
    private Maquina maquina;

    public ImagemMaquina() { }

    public ImagemMaquina(String nome, String tipo, Long tamanho, byte[] conteudo, Long idMaquina) {
        this.nome = nome;
        this.tipo = tipo;
        this.tamanho = tamanho;
        this.conteudo = conteudo;

        final var maquina = new Maquina();
        maquina.setId(idMaquina);

        this.maquina = maquina;
    }

}
