package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> { }
