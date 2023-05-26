package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.AvaliacaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoUsuarioRepository extends JpaRepository<AvaliacaoUsuario, Long> { }
