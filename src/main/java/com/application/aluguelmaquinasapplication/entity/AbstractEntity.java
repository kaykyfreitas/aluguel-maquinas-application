package com.application.aluguelmaquinasapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@Table
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Timestamp data_alteracao;
    @NotNull
    protected Timestamp data_inclusao;

    @PrePersist
    protected void prePersist() {
        this.data_inclusao = Timestamp.from(Instant.now());
    }

    @PreUpdate
    protected void preUpdate() {
        this.data_alteracao = Timestamp.from(Instant.now());
    }

}
