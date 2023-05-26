package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaquinaRepository extends JpaRepository<Maquina, Long> { }
