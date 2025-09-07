package org.example.yardflow.repository;

import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RegistroCheckInOutRepositorio extends JpaRepository<RegistroCheckInOut, Integer> {


    // Consulta feita a partir da data de entrada para localizar o Id da Moto
    @Query("from RegistroCheckInOut rG where rG.entrada_patio = :entrada_patio")
    Optional<RegistroCheckInOut> buscarDataEntradaMoto(@Param("entrada_patio")LocalDate entrada_patio);

    // Consulta feita a partir da data de saida para localizar o Id da Moto
    @Query("from RegistroCheckInOut rG where rG.saida_patio = :saida_patio")
    Optional<RegistroCheckInOut> buscarDataSaidaMoto(@Param("saida_patio") LocalDate saida_patio);

    // Consulta por periodo de permanencia por setor e por modelo - do maior para o menor
    @Query("select vg.setor as setor, mt.modelo as modelo, sum(rg.periodo) as totalDias from RegistroCheckInOut rg " +
            "join rg.vaga vg join rg.moto mt group by vg.setor, mt.modelo order by sum(rg.periodo) desc")
    Page<PermanenciaPorSetorModeloDTO> buscarPermanenciaPorSetorModelo(Pageable pageable);
}
