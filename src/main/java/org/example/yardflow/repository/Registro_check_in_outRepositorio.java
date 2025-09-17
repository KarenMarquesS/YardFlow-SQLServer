package org.example.yardflow.repository;

import org.example.yardflow.model.Registro_check_in_out;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Repository
public interface Registro_check_in_outRepositorio extends JpaRepository<Registro_check_in_out, Integer> {

    //Lista das DATAS DE ENTRADA E DE SAIDA
    List<Registro_check_in_out> findByEntradaPatio(LocalDate entradaPatio);

    List<Registro_check_in_out> findBySaidaPatio(LocalDate saidaPatio);


    // Consulta feita a partir da data de entrada para localizar o Id da Moto
    @Query("from Registro_check_in_out rG where rG.entrada_patio = :entrada_patio")
    Optional<Registro_check_in_out> buscarDataEntradaMoto(@Param("entrada_patio")LocalDate entrada_patio);

    // Consulta feita a partir da data de saida para localizar o Id da Moto
    @Query("from Registro_check_in_out rG where rG.saida_patio = :saida_patio")
    Optional<Registro_check_in_out> buscarDataSaidaMoto(@Param("saida_patio") LocalDate saida_patio);



}
