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


    List<Registro_check_in_out> findAllByEntradaPatio(LocalDate entrada_patio);


    List<Registro_check_in_out> findAllBySaidaPatio(LocalDate saida_patio);

    // Encontra o registro em aberto (entrada sem saída) mais recente da moto
    Optional<Registro_check_in_out> findTopByMoto_IdAndSaidaPatioIsNullOrderByEntradaPatioDesc(int id_moto);

    // Encontra o último registro (fechado ou não) pela moto
    Optional<Registro_check_in_out> findTopByMoto_IdOrderByEntradaPatioDesc(int id_moto);

    // Lista todos os registros de uma moto
    List<Registro_check_in_out> findByMoto_Id(int id_moto);

    // Lista todos com entrada (útil para ordenar por permanência em memória)
    List<Registro_check_in_out> findByEntradaPatioIsNotNull();



}
