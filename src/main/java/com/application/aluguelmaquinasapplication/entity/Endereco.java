package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance
public final class Endereco extends AbstractEntity {

    @NotNull
    @Size(max = 8)
    private String cep;
    @NotNull
    @Size(max = 150)
    private String rua;
    @NotNull
    private Long numero;
    @NotNull
    @Size(max = 50)
    private String cidade;
    @NotNull
    @Size(max = 50)
    private String bairro;
    @NotNull
    @Size(max = 2)
    private String uf;
    @NotNull
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Endereco() { }

    public Endereco(String cep, String rua, Long numero, String cidade, String bairro, String uf) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", cidade='" + cidade + '\'' +
                ", bairro='" + bairro + '\'' +
                ", uf='" + uf + '\'' +
                ", usuario.id=" + usuario.id +
                '}';
    }
}
