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

}
