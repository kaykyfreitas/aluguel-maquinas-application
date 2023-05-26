package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> { }
