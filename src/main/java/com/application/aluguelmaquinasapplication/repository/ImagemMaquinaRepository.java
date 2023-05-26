package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.ImagemMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemMaquinaRepository extends JpaRepository<ImagemMaquina, Long> { }
