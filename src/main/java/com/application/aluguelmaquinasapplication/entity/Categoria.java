package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name="categorias")
public class Categoria {
    
    @Id
    private Integer id;
    private String categoria;

    @OneToOne(mappedBy = "categoria")
    private Maquina maquina;

}
