package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.ImagemMaquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ImagemMaquinaRepository extends JpaRepository<ImagemMaquina, Long> {
    @Query("select i from ImagemMaquina i where i.maquina.id = ?1")
    List<ImagemMaquina> findByMaquina_Id(Long id);

}
