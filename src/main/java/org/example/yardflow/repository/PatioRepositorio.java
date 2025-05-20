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
    public Patio buscarPorSetor(@Param("setor") SetorEnum setor);

    @Query("from Patio pT JOIN pT.vaga v where v.id_vaga = :id_vaga")
    public Patio buscarPorIdVagas(@Param("id_vaga") String id_vaga);

    @Query("SELECT pT from Patio pT where pT.qtd_vagas = :qtd_vagas")
    public List<Vaga> mostrarQtdVagas(@Param("id_patio")int qtd_vagas);

    @Query("SELECT pT.setor, COUNT(v) FROM Patio pT JOIN pT.vaga v WHERE v.ocupada = true GROUP BY pT.setor")
    public List<SetorEnum> mostrarVagaOcupadaPorSetor();

}
