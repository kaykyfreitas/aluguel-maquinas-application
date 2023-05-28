package com.application.aluguelmaquinasapplication.repository;

import com.application.aluguelmaquinasapplication.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

//    @Query("select * from Reserva r where r.maquina.id = ?1")
//    List<Reserva> findAllByMaquina_Id(Long id);
//
//    @Query("select * from Reserva r where r.usuario.id = ?1")
//    List<Reserva> findAllByUsuario_Id(Long id);
//
//    @Query(
//            nativeQuery = true,
//            value = "select * from reserva r where curdate() < dataPrevDevolucao"
//    )
//    List<Reserva> findAllReservasAbertas();
//
//    @Query(
//            nativeQuery = true,
//            value = "select * from reserva r where curdate() > dataPrevDevolucao"
//    )
//    List<Reserva> findAllReservasFechadas();

}
