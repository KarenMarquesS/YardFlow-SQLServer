package org.example.yardflow.repository;


import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VagaRepositorio extends JpaRepository<Vaga, Integer> {

    // verifica se a vaga está ocupada
    @Query("from Vaga vG where vG.ocupada = :ocupado ")
    public List<Vaga> vagaOcupada(@Param("ocupado") boolean ocupado);

    // busca pelo IdVaga
    @Query("from Vaga vG where vG.id_vaga = :id_vaga")
    public List<Vaga> buscarIdVaga(@Param("id_vaga") int id_vaga);

    // Busca todas vagas por setor
    @Query("from Vaga vG where vG.setor = :setor")
    public List<Vaga> buscarVagaSetor(@Param("setor") SetorEnum setor);

}