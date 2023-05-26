package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "endereco")
public class Endereco {
    
    @Id
    private Integer id;
    private String cep;
    private String rua;
    private Long numero;
    private String cidade;
    private String bairro;
    private String uf;
    @OneToOne
    @JoinColumn(name = "cpf_usuario")
    private Usuario usuario;

}
