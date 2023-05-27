package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Inheritance
public final class Categoria extends AbstractEntity {

    @NotNull
    @Size(max = 40)
    private String nome;

    @OneToOne(mappedBy = "categoria")
    private Maquina maquina;

    public Categoria() { }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
