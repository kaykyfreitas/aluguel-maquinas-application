package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> { }
