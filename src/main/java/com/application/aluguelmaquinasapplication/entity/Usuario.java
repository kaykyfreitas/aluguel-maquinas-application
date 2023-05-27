package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance
public final class Usuario extends AbstractEntity {

    @NotNull
    @Size(max = 11)
    private String cpf;
    @NotNull
    @Size(max = 80)
    private String nome;
    @NotNull
    @Size(max = 200)
    private String email;
    @NotNull
    @Size(max = 11)
    private String telefone;
    @NotNull
    @Size(max = 100)
    private String senha;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Reserva> reservas = new ArrayList<>();

    public Usuario() { }

    public Usuario(Long id, String cpf, String nome, String email, String telefone, String senha, Endereco endereco) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + endereco.toString() +
                '}';
    }
}
