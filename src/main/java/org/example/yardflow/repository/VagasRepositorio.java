package org.example.yardflow.repository;

import org.example.yardflow.model.Moto;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VagasRepositorio extends JpaRepository<Vaga, String> {

    // Busca todas vagas disponíveis por setor
    @Query("from Vaga vG where vG.ocupada = :ocupado ")
    List<Vaga> findByVaga(Vaga vaga);

    // Busca de moto por vaga
    @Query("from Vaga vG where vG.moto = :idMoto")
    List<Vaga> findByMoto(Moto moto);

    @Query("from Vaga vG where vG.moto = :idVaga")
    List<Vaga> findByIdVaga(Vaga vaga);

    @Query("from Vaga vG where vG.setor = :SetorEnum")
    List<Vaga> findBySetor(SetorEnum setor);

}