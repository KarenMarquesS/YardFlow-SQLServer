package org.example.yardflow.repository;

import org.example.yardflow.model.Yardflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface YardflowRepositorio extends JpaRepository<Yardflow, Integer> {

    Optional<Yardflow> findBySerial(@Param("serial")String serial);

    Yardflow findByDtUltimoAcionamento(LocalDateTime dt_ultimo_acionamento);

}

