package org.example.yardflow.repository;


import org.example.yardflow.model.EnumSetor;
import org.example.yardflow.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface VagaRepositorio extends JpaRepository<Vaga, Integer> {

    // verifica se a vaga está ocupada
    @Query("from Vaga vG where vG.ocupada = :ocupado ")
    List<Vaga> vagaOcupada(@Param("ocupado") boolean ocupado);

    // busca pelo IdVaga
    @Query("from Vaga vG where vG.id_vaga = :id_vaga")
    Optional<Vaga> findByIdVaga(@Param("id_vaga") int id_vaga);

    // Busca todas vagas por setor
    @Query("from Vaga vG where vG.setor = :setor")
    List<Vaga> findVagaBySetor(@Param("setor") EnumSetor setor);

}