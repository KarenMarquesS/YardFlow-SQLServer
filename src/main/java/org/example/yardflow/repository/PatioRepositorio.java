package org.example.yardflow.repository;

import org.example.yardflow.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepositorio extends JpaRepository<Patio, Integer> {

    Patio findById(@Param("id")int id_patio);

    Patio findByqtd_vagas(int qtd_vagas);

    Patio findByNickname(String nickname);

}
