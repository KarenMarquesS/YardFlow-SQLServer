package org.example.yardflow.repository;

import org.example.yardflow.model.RegistroCheckInOut;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface RegistroCheckInOutRepositorio extends JpaRepository<RegistroCheckInOut, Integer> {


    // Consulta feita a partir da data de entrada para localizar o Id da Moto
    @Query("from RegistroCheckInOut rG where rG.entradaPatio = :entradaPatio")
    public RegistroCheckInOut buscarDataEntradaMoto(@Param("entradaPatio")LocalDate entradaPatio);

    // Consulta feita a partir da data de saida para localizar o Id da Moto
    @Query("from RegistroCheckInOut rG where rG.saidaPatio = :saidaPatio")
    public RegistroCheckInOut buscarDataSaidaMoto(@Param("saidaPatio") LocalDate saidaPatio);

    // Consulta por periodo de permanencia por setor e por modelo - do maior para o menor
    @Query("select vg.setor as setor, mt.modelo as modelo, sum(rg.periodo) as totalDias from RegistroCheckInOut rg " +
            "join rg.vaga vg join rg.idMoto mt group by vg.setor, mt.modelo order by sum(rg.periodo) desc")
    public Page<PermanenciaPorSetorModeloDTO> buscarPermanenciaPorSetorModelo(Pageable pageable);
}
