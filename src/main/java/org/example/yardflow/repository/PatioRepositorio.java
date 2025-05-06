package org.example.yardflow.repository;//package org.example.parkflow.repository;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.example.yardflow.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatioRepositorio extends JpaRepository<Patio, Integer> {

    @Query("from Patio pT where pT.setor = :setor")
    public Patio findBySetor(SetorEnum setor);

    @Query("from Patio pT where pT.vagas = :idVaga")
    public Patio findByVagas(@Param("idVagas") int idVagas);

    @Query("from Patio pT where pT.qtdVagas = :qtdVaga")
    public List<Vaga> mostrarQtdVagas(@Param("idPatio")int qtdVaga);

}
