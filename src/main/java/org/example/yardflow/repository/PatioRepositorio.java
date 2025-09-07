package org.example.yardflow.repository;

import org.example.yardflow.model.Patio;
import org.example.yardflow.model.EnumSetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatioRepositorio extends JpaRepository<Patio, Integer> {

    Optional<Patio> findByIdPatio(@Param("id_patio")int id_patio);

    @Query("FROM Patio pT WHERE pT.setor = :setor")
    List<Patio> findBySetor(@Param("setor") EnumSetor setor);

    @Query("FROM Patio pT JOIN pT.vagas v WHERE v.id_vaga = :id_vaga")
    Patio findByIdVaga(@Param("id_vaga") int id_vaga);

    @Query("SELECT pT FROM Patio pT WHERE pT.qtd_vagas = :qtd_vagas")
    List<Patio> findByQtdVagas(@Param("qtd_vagas") int qtd_vagas);

    @Query("SELECT pT.setor, COUNT(v) FROM Patio pT JOIN pT.vagas v WHERE v.ocupada = true GROUP BY pT.setor")
    List<Object[]> contarVagaOcupadaPorSetor();
}
