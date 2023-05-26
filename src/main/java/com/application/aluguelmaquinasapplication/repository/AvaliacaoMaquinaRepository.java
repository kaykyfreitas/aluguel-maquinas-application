package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.AvaliacaoMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoMaquinaRepository extends JpaRepository<AvaliacaoMaquina, Long> { }
