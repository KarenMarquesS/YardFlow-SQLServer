package org.example.yardflow.repository;


import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VagaRepositorio extends JpaRepository<Vaga, String> {

    // Busca todas vagas disponíveis por setor
    @Query("from Vaga vG where vG.ocupada = :ocupado ")
    public List<Vaga> findByVaga(@Param("ocupado") boolean ocupado);

    @Query("from Vaga vG where vG.idVaga = :idVaga")
    public List<Vaga> findByIdVaga(@Param("idVaga") String idVaga);

    @Query("from Vaga vG where vG.setor = :setor")
    public List<Vaga> findBySetor(@Param("setor") SetorEnum setor);

}