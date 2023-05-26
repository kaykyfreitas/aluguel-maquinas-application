package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;

    @OneToOne(mappedBy = "usuario")
    private Endereco endereco;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

}
