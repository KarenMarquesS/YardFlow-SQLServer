package org.example.yardflow.repository;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.SetorEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatioRepositorio extends JpaRepository<Patio, Integer> {

    @Query("FROM Patio pT WHERE pT.setor = :setor")
    public Patio buscarPorSetor(@Param("setor") SetorEnum setor);

    @Query("FROM Patio pT JOIN pT.vaga v WHERE v.id_vaga = :id_vaga")
    public Patio buscarPorIdVagas(@Param("id_vaga") int id_vaga);

    @Query("SELECT pT FROM Patio pT WHERE pT.qtd_vagas = :qtd_vagas")
    public List<Patio> mostrarQtdVagas(@Param("qtd_vagas") int qtd_vagas);

    @Query("SELECT pT.setor, COUNT(v) FROM Patio pT JOIN pT.vaga v WHERE v.ocupada = true GROUP BY pT.setor")
    public List<Object[]> mostrarVagaOcupadaPorSetor();
}
