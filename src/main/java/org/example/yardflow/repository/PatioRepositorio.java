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
    public Patio buscarPorSetor(@Param("setor") SetorEnum setor); // alterar para retornar todas as vagas de cada setor

    @Query("from Patio pT JOIN pT.vagas v where v.idVaga = :idVaga")
    public Patio buscarPorIdVagas(@Param("idVaga") String idVaga);

    @Query("SELECT pT from Patio pT where pT.qtdVagas = :qtdVaga")
    public List<Vaga> mostrarQtdVagas(@Param("idPatio")int qtdVaga);

    @Query("SELECT pT.setor, COUNT(v) FROM Patio pT JOIN pT.vagas v WHERE v.ocupada = true GROUP BY pT.setor")
    public List<SetorEnum> mostrarVagaOcupadaPorSetor();

}
