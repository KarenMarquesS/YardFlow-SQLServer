package org.example.yardflow.repository;

import org.example.yardflow.model.Registro_check_in_out;
import org.example.yardflow.projection.PermanenciaPorSetorModeloDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface Registro_check_in_outRepositorio extends JpaRepository<Registro_check_in_out, Integer> {


    // Consulta feita a partir da data de entrada para localizar o Id da Moto
    @Query("from Registro_check_in_out rG where rG.entrada_patio = :entrada_patio")
    public Registro_check_in_out buscarDataEntradaMoto(@Param("entrada_patio")LocalDate entrada_patio);

    // Consulta feita a partir da data de saida para localizar o Id da Moto
    @Query("from Registro_check_in_out rG where rG.saida_patio = :saida_patio")
    public Registro_check_in_out buscarDataSaidaMoto(@Param("saida_patio") LocalDate saida_patio);

    // Consulta por periodo de permanencia por setor e por modelo - do maior para o menor
    @Query("select vg.setor as setor, mt.modelo as modelo, sum(rg.periodo) as totalDias from Registro_check_in_out rg " +
            "join rg.vaga vg join rg.id_moto mt group by vg.setor, mt.modelo order by sum(rg.periodo) desc")
    public Page<PermanenciaPorSetorModeloDTO> buscarPermanenciaPorSetorModelo(Pageable pageable);
}
